package com.xpj.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	public ScheduledTasks() {
		System.err.println("Bean实例化成功");
	}

	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		System.err.println("定时任务已经启动");
		logger.info("The time is now {}", format.format(new Date()));
	}
}
