package com.demo.fancy.common.model;

import com.demo.fancy.common.constants.RpcStatusEnum;
import com.demo.fancy.common.exception.RpcException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fancy
 * @date 2025/2/25 21:03
 */
public class RpcResponse implements Serializable {

    private String requestId;

    private Map<String, String> headers = new HashMap<>();

    private Object returnValue;

    private RpcException exception;

    private Integer rpcStatus;

    public RpcResponse() {
    }

    public RpcResponse(RpcStatusEnum rpcStatus) {
        this.rpcStatus = rpcStatus.getCode();
    }

    public RpcResponse(RpcStatusEnum rpcStatus, String requestId) {
        this.rpcStatus = rpcStatus.getCode();
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    public RpcException getException() {
        return exception;
    }

    public void setException(RpcException exception) {
        this.exception = exception;
    }

    public Integer getRpcStatus() {
        return rpcStatus;
    }

    public void setRpcStatus(Integer rpcStatus) {
        this.rpcStatus = rpcStatus;
    }
}
