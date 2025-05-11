package com.demo.fancy.annotation;
import java.lang.annotation.*;

/**
 * @author fancy
 * @date 2025/3/19 12:24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MessageProtocolAno {
    String value() default "";
}
