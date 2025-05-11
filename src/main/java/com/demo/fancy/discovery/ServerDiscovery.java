package com.demo.fancy.discovery;

import com.demo.fancy.common.model.Service;

import java.util.List;

/**
 *
 * 服务发现抽象类
 * @author fancy
 * @date 2025/2/25 11:05
 */
public interface ServerDiscovery {

    /**
     * 服务暴露
     * @param serviceResource
     */
    void exportService(Service serviceResource);

    /**
     * 根据服务名查找服务列表
     * @param serviceName
     * @return
     */
    List<Service> findServiceList(String serviceName);

    /**
     * 注册服务监听
     */
    void registerChangeListener(String serviceName);
}
