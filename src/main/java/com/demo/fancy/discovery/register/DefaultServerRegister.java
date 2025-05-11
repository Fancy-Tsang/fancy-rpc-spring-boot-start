package com.demo.fancy.discovery.register;

import com.demo.fancy.config.properties.RpcConfig;
import com.demo.fancy.discovery.ServerDiscovery;
import com.demo.fancy.discovery.ServerRegister;
import com.demo.fancy.discovery.ServiceObject;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认服务注册器
 *
 * @author fancy
 * @date 2025/3/26 13:18
 */
public class DefaultServerRegister implements ServerRegister {

    private Map<String, ServiceObject> serviceMap = new HashMap<>();

    private ServerDiscovery serverDiscovery;

    private RpcConfig rpcConfig;

    public DefaultServerRegister(ServerDiscovery serverDiscovery, RpcConfig rpcConfig) {
        this.serverDiscovery = serverDiscovery;
        this.rpcConfig = rpcConfig;
    }

    @Override
    public void register(ServiceObject so) throws Exception {
        if (so == null) {
            throw new IllegalArgumentException("parameter cannot be empty");
        }
        serviceMap.put(so.getName(), so);
        Service service = new Service();
        String host = InetAddress.getLocalHost().getHostAddress();
        service.setIp(host);
        service.setPort(rpcConfig.getServerPort());
        service.setName(so.getClazz().getName());
        service.setProtocol(rpcConfig.getProtocol());
        service.setWeight(rpcConfig.getWeight());
        serverDiscovery.exportService(service);
    }

    @Override
    public ServiceObject getServiceObject(String name) throws Exception {
        return serviceMap.get(name);
    }
}
