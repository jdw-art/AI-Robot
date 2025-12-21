package com.jacob.ai.robot.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Jacob
 * @Description: OkHttp 客户端配置类
 * @Date: 2025/12/21 16:04
 * @Version: 1.0
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient(
            @Value("${okhttp.connect-timeout}") int connectTimeout,
            @Value("${okhttp.read-timeout}") int readTimeout,
            @Value("${okhttp.write-timeout}") int writeTimeout,
            @Value("${okhttp.max-idle-connections}") int maxIdleConnections,
            @Value("${okhttp.keep-alive-duration}") int keepAliveDuration) {


        return new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MINUTES))
                .build();
    }

}