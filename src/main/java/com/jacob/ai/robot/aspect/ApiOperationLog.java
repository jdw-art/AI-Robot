package com.jacob.ai.robot.aspect;

import java.lang.annotation.*;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2025/9/23 23:18
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";

}