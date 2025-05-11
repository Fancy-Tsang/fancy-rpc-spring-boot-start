package com.demo.fancy.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author fancy
 * @version 1.0.0
 * @description:
 * @date 2023/03/18 15:44
 */
public class ClassUtils {

    public static final String CLASS_EXTENSION = ".class";

    public static final String JAVA_EXTENSION = ".java";

    public static URI toURI(String name) {
        try {
            return new URI(name);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}