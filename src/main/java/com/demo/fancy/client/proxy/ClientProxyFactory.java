package com.demo.fancy.client.proxy;

/**
 * @Author: fancy
 * @Description:
 * @Date: Created in 2025/3/10
 */
public interface ClientProxyFactory {

    /**
     * 获取客户端服务代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getProxy(Class<T> clazz);
}
