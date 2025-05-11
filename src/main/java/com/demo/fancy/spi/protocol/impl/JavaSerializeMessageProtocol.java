package com.demo.fancy.spi.protocol.impl;

import com.demo.fancy.annotation.MessageProtocolAno;
import com.demo.fancy.common.constants.RpcConstant;
import com.demo.fancy.common.model.RpcRequest;
import com.demo.fancy.common.model.RpcResponse;
import com.demo.fancy.spi.protocol.MessageProtocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java序列化消息协议
 *
 * @author fancy
 * @date 2025/3/2 14:35
 */
@MessageProtocolAno(RpcConstant.PROTOCOL_JAVA)
public class JavaSerializeMessageProtocol implements MessageProtocol {

    private byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(o);
        return bout.toByteArray();

    }


    @Override
    public byte[] marshallingRequest(RpcRequest request) throws Exception {
        return this.serialize(request);
    }

    @Override
    public RpcRequest unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RpcRequest) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(RpcResponse response) throws Exception {
        return this.serialize(response);
    }

    @Override
    public RpcResponse unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RpcResponse) in.readObject();
    }
}
