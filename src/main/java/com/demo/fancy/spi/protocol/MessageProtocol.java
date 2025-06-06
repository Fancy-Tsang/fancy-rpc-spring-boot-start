package com.demo.fancy.spi.protocol;

import com.demo.fancy.common.model.RpcRequest;
import com.demo.fancy.common.model.RpcResponse;

/**
 *消息协议:定义编组请求、解组请求、编组响应、解组响应的规范
 * @author fancy
 * @date 2025/2/25 20:21
 */
public interface MessageProtocol {
    /**
     * 编组请求
     * @param request 请求信息
     * @return 请求字节数组
     * @throws Exception
     */
    byte[] marshallingRequest(RpcRequest request) throws Exception;

    /**
     * 解组请求
     * @param data
     * @return
     * @throws Exception
     */
    RpcRequest unmarshallingRequest(byte[] data) throws Exception;

    /**
     * 编组响应
     * @param response
     * @return
     */
    byte[] marshallingResponse(RpcResponse response) throws Exception;

    /**
     * 解组响应
     * @param data
     * @return
     * @throws Exception
     */
    RpcResponse unmarshallingResponse(byte[] data) throws Exception;
}
