package com.demo.fancy.discovery;

/**
 * 服务注册器，定义服务注册规范
 * @author fancy
 * @date 2025/3/26 17:15
 */
public interface ServerRegister {

    /**
     * 注册
     * @param so
     * @throws Exception
     */
    void register(ServiceObject so)throws Exception;

    ServiceObject getServiceObject(String name)throws Exception;
}
