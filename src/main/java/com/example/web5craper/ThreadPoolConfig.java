package com.example.web5craper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int COUR_SIZE = CPU_COUNT * 2;
    private static final int MAX_COUR_SIZE = CPU_COUNT * 4;

    @Bean("tpExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor tpExecutor = new ThreadPoolTaskExecutor();
        tpExecutor.setCorePoolSize(COUR_SIZE);// 设置核心线程数
        tpExecutor.setMaxPoolSize(MAX_COUR_SIZE);// 配置最大线程数
        tpExecutor.setQueueCapacity(MAX_COUR_SIZE * 4);// 配置队列容量（这里设置成最大线程数的四倍）
        tpExecutor.setThreadNamePrefix("Anno-Executor");// 给线程池设置名称
        tpExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());// 设置任务的拒绝策略
        return tpExecutor;
    }
}
