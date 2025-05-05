package com.demo.fancy.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 被该注解标记的服务可提供远程RPC访问功能
 * @author fancy
 * @date 2025/2/26 15:15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Documented
public @interface Service {
    String value() default "";
}
