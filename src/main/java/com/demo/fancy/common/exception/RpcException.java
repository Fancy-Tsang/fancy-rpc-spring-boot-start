package com.demo.fancy.common.exception;
/**
 * @author fancy
 * @date 2025/2/25 16:35
 */
public class RpcException extends RuntimeException{
    public RpcException(String message) {
        super(message);
    }
}
