package com.demo.fancy.spi.protocol.impl;

import com.demo.fancy.annotation.MessageProtocolAno;
import com.demo.fancy.common.constants.RpcConstant;
import com.demo.fancy.common.model.RpcRequest;
import com.demo.fancy.common.model.RpcResponse;
import com.demo.fancy.spi.protocol.MessageProtocol;
import com.demo.fancy.util.SerializingUtil;

/**
 * Protobuf序列化协议
 * @author fancy
 * @date 2025/3/5 12:22
 */
@MessageProtocolAno(RpcConstant.PROTOCOL_PROTOBUF)
public class ProtoBufMessageProtocol implements MessageProtocol {

    @Override
    public byte[] marshallingRequest(RpcRequest request) throws Exception {
        return SerializingUtil.serialize(request);
    }

    @Override
    public RpcRequest unmarshallingRequest(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data,RpcRequest.class);
    }

    @Override
    public byte[] marshallingResponse(RpcResponse response) throws Exception {
        return SerializingUtil.serialize(response);
    }

    @Override
    public RpcResponse unmarshallingResponse(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data, RpcResponse.class);
    }
}
