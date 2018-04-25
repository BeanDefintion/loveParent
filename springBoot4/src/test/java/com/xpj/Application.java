package com.xpj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com"})
@MapperScan(basePackages = "com.**.mapper")
public class Application {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(Application.class, args);
        // AbstractList<E>
    }

//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(new data);
//		return sessionFactory.getObject();
//	}

}
