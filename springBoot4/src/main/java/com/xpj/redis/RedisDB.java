package com.xpj.redis;

import com.typesafe.config.ConfigFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class RedisDB {
    private static volatile JedisPool jedisPool = null;
    private static int expireTime = 1800; // session 在redis过期时间是30分钟30*60
    private static int countExpireTime = 2 * 24 * 3600; // 计数器的过期时间默认2天
    // private String password = "123456";
    private static String redisIp = ConfigFactory.load().getString("redis.ip");
    private static int redisPort = ConfigFactory.load().getInt("redis.port");
    private static int maxActive = 200;
    private static int maxIdle = 200;
    private static long maxWait = 5000;

    private static Object obj = new Object();

    static {
        initPool();
    }

    /**
     * 初始化JedisPool(连接池的性能更优秀),所以连接池用1个，而连接不能只用1个，单例模式也不能乱用
     *
     * @return
     */
    private static JedisPool initPool() {
        if (jedisPool == null) {
            synchronized (obj) {
                if (jedisPool == null) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(maxActive);
                    config.setMaxIdle(maxIdle);
                    config.setMaxWaitMillis(maxWait);
                    config.setTestOnBorrow(false);

                    jedisPool = new JedisPool(config, redisIp, redisPort, 10000);
                    System.err.println(jedisPool);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 获得Jedis连接(这里如果用双重隔离锁的话，Jedis!=null,在后面的判断中jedis就是IDLE(IDLE,空闲,在队列中;
     * ALLOCATED:在使用)所以报错)
     *
     * @return
     */
    private static Jedis getJedis() {
        Jedis jedis = null;
        if (jedis == null) {
            synchronized (obj) {
                if (jedis == null) {
                    jedis = jedisPool.getResource();
                }
            }
        }
        return jedis;
    }

    /**
     * 回收Jedis连接
     *
     * @param jedis
     */
    private static void recycleJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * @param key
     * @param value
     */
    public static void setString(String key, String value) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            try {
                jedis.set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                recycleJedis(jedis);
            }
        }
    }

    /**
     * 创建set集合
     *
     * @param key
     * @param members
     */
    public static void sadd(String key, String... members) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            try {
                jedis.sadd(key, members);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                recycleJedis(jedis);
            }
        }
    }

    /**
     * 判断redis中是否存在某个key
     *
     * @param key
     * @return
     */
    public static boolean exists(String key) {
        Jedis jedis = getJedis();
        return jedis.exists(key);
    }

    /**
     * 获取所有keys
     *
     * @param pattern
     * @return
     */
    public static Set<String> getAllKeys(String pattern) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            try {
                return jedis.keys(pattern);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                recycleJedis(jedis);
            }
        }
        return null;
    }

    /**
     * 保存byte类型数据
     *
     * @param key
     * @param value
     */
    public static void setObject(byte[] key, byte[] value) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            try {
                jedis.set(key, value);
                // redis中session过期时间
                jedis.expire(key, expireTime);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                recycleJedis(jedis);
            }
        }
    }

    /**
     * 获取byte类型数据
     *
     * @param key
     * @return
     */
    public static byte[] getObject(byte[] key) {
        Jedis jedis = getJedis();
        byte[] bytes = null;
        if (jedis != null) {
            try {
                bytes = jedis.get(key);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                recycleJedis(jedis);
            }
        }
        return bytes;

    }

    public static void main(String[] args) {
        sadd("xpj", "SHuaiB", "SBBB", "ssssss");
        setString("1", "2");
        setString("1", "2222");
    }
}
