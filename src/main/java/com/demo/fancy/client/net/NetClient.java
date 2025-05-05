package com.demo.fancy.client.net;

import com.demo.fancy.common.model.RpcRequest;
import com.demo.fancy.common.model.RpcResponse;
import com.demo.fancy.common.model.Service;
import com.demo.fancy.spi.protocol.MessageProtocol;

/**
 *
 * 网络请求客户端，定义请求规范
 * @author fancy
 * @date 2025/1/15 15:31
 *
 */
public interface NetClient {
    /**
     * 发送请求
     * @param rpcRequest
     * @param service
     * @param messageProtocol
     * @return
     */
    RpcResponse sendRequest(RpcRequest rpcRequest, Service service, MessageProtocol messageProtocol);
}
