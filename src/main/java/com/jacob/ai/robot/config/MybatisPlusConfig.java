package com.jacob.ai.robot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2025/9/23 21:20
 * @Version: 1.0
 */
@Configuration
@MapperScan("com.jacob.ai.robot.domain.mapper")
public class MybatisPlusConfig {
}
