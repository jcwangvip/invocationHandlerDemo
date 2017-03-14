package com.jc.aop;

import java.lang.reflect.Method;

/**
 * 
 * The Class AfterHandler provides a template for After concern.
 * 类提供了一个模板后，关注afterhandler。
 * 
 * @author asdc
 */
public abstract class AfterHandler extends AbstractHandler {

	/**
	 * Handles after the execution of method.
	 *
	 * @param proxy the proxy
	 * @param method the method
	 * @param args the args
	 */
	public abstract void handleAfter(Object proxy, Method method, Object[] args);
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = method.invoke(getTargetObject(), args);
		handleAfter(proxy, method, args);
		return result;
	}
}
