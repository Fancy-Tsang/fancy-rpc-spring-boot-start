package com.demo.fancy.client.net;
/**
 * @Author: fancy
 * @Description:
 * @Date: Created in 2025/1/15
 */
public class NetClientFactory {
    private NetClientFactory(){

    }

    public static NetClient getInstance() {
        return new NettyNetClient();
    }
}
