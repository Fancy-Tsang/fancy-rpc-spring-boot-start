package com.demo.fancy.client.generic;

import com.demo.fancy.client.core.MethodInvoker;

/**
 * @Author: fancy
 * @Description:
 * @Date: Created in 2025/2/15
 */
public class DefaultGenericService implements GenericService {

    private MethodInvoker methodInvoker;

    private String interfaceClassName;

    public DefaultGenericService(MethodInvoker methodInvoker, String interfaceClassName) {
        this.methodInvoker = methodInvoker;
        this.interfaceClassName = interfaceClassName;
    }

    @Override
    public Object $invoke(String methodName, String[] parameterTypeNames, Object[] args) {
        return methodInvoker.$invoke(interfaceClassName, methodName, parameterTypeNames, args, true);
    }
}
