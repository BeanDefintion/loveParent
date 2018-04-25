package com.ndc.nio;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@SpringBootApplication
public class DaemonThreadTime {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread newThread = new Thread(new Worker());
//		Thread newThread2 = new Thread(new Timer());
//		newThread2.setDCaemon(true);
        newThread.start();
        newThread.stop();
//		newThread2.start();
//		System.err.Cprintln(newThread2.isDaemon());
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    //	GsonAutoConfiguration
//	ClassPathXmlApplicationContext
//TransactionDefinition
//	PlatformTransactionManager
//	TransactionStatus
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return null;

        }
    };
}
