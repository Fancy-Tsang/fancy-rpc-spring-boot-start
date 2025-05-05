package com.demo.fancy.server;

import com.alibaba.fastjson.JSON;
import com.demo.fancy.common.constants.RpcStatusEnum;
import com.demo.fancy.common.exception.RpcException;
import com.demo.fancy.common.model.RpcRequest;
import com.demo.fancy.common.model.RpcResponse;
import com.demo.fancy.discovery.ServerRegister;
import com.demo.fancy.discovery.ServiceObject;
import com.demo.fancy.spi.protocol.MessageProtocol;
import com.demo.fancy.util.ReflectUtils;
import com.demo.fancy.util.RpcResponseUtils;

import java.lang.reflect.Method;

/**
 * 请求处理者，提供解组请求、编组响应等操作
 *
 * @author fancy
 * @date 2025/2/26 15:26
 */
public class RequestHandler {

    private MessageProtocol protocol;


    private ServerRegister serverRegister;

    public RequestHandler(MessageProtocol protocol, ServerRegister serverRegister) {
        this.protocol = protocol;
        this.serverRegister = serverRegister;
    }


    public byte[] handleRequest(byte[] data) throws Exception {
        // 1.解组消息
        RpcRequest req = this.protocol.unmarshallingRequest(data);

        // 2.查找服务对应
        ServiceObject so = serverRegister.getServiceObject(req.getServiceName());

        RpcResponse response = null;

        if (so == null) {
            response = new RpcResponse(RpcStatusEnum.NOT_FOUND);

        } else {
            try {
                // 3.反射调用对应的方法过程
                Method method = so.getClazz().getMethod(req.getMethod(), ReflectUtils.convertToParameterTypes(req.getParameterTypeNames()));
                Object returnValue = method.invoke(so.getObj(), req.getParameters());
                response = new RpcResponse(RpcStatusEnum.SUCCESS);
                if (req.getGeneric()) {
                    response.setReturnValue(RpcResponseUtils.handlerReturnValue(returnValue));
                } else {
                    response.setReturnValue(returnValue);
                }
            } catch (Exception e) {
                response = new RpcResponse(RpcStatusEnum.ERROR);
                String errMsg = JSON.toJSONString(e);
                response.setException(new RpcException(errMsg));
            }
        }
        // 编组响应消息
        response.setRequestId(req.getRequestId());
        return this.protocol.marshallingResponse(response);
    }


}
