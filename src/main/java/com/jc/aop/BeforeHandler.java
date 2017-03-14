package com.jc.aop;

import java.lang.reflect.Method;

/**
 * The Class BeforeHandler provides a template for the before execution
 *
 * @author asdc
 */
public abstract class BeforeHandler extends AbstractHandler {

	/**
	 * Handles before execution of actual method.
	 *
	 * @param proxy the proxy
	 * @param method the method
	 * @param args the args
	 */
	public abstract void handleBefore(Object proxy, Method method, Object[] args);
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		handleBefore(proxy, method, args);
		Object obj = method.invoke(getTargetObject(), args);
		return obj;
	}
}
