package com.demo.fancy.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fancy
 * @date 2025/2/26 12:54
 */
@ConfigurationProperties(prefix = "sp.rpc")
public class RpcConfig {

    /**
     * 服务注册中心地址
     */
    private String registerAddress = "127.0.0.1:2181";
    /**
     * 注册中心类型，默认nacos
     */
    private String registerCenterType = "nacos";

    /**
     * 服务暴露端口
     */
    private Integer serverPort = 9999;
    /**
     * 服务协议
     */
    private String protocol = "java";
    /**
     * 负载均衡算法
     */
    private String loadBalance = "random";
    /**
     * 权重，默认为1
     */
    private Integer weight = 1;
    /**
     * 客户端代理对象生成方式，默认JDK动态代理
     */
    private String proxyType = "jdk";


    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public String getRegisterCenterType() {
        return registerCenterType;
    }

    public void setRegisterCenterType(String registerCenterType) {
        this.registerCenterType = registerCenterType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(String loadBalance) {
        this.loadBalance = loadBalance;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
