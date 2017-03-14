package com.jc.factory;

import java.lang.reflect.Proxy;
import java.util.List;

import com.jc.aop.AbstractHandler;


/**
 *  A factory for creating Proxy objects.
 * 创建代理对象的工厂。
 * @author asdc
 */
public class ProxyFactory {

	/**
	 * Gets the proxy.
	 *
	 * @param targetObject the target object
	 * @param handlers the handlers		处理程序
	 * @return the proxy
	 */
	public static Object getProxy(Object targetObject,List<AbstractHandler> handlers) {
		Object proxyObject = null;
		if (handlers.size() > 0) {
			proxyObject = targetObject;
			for (int i = 0; i < handlers.size(); i++) {
				handlers.get(i).setTargetObject(proxyObject);
				/**
				 * @param装载的类装载器来定义代理类
				 * @param接口的代理类的接口列表
				 * @param调用处理程序调度方法调用*用指定的调用处理程序返回代理实例*由指定类别载入器定义的代理类别*并实现指定的接口
				 */
				proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), handlers.get(i));
				//System.out.println("for循环里获取的代理类"+proxyObject);
				 //生成$Proxy0的class文件
		        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
			}
			//System.out.println("获取代理类后最后返回代理类"+proxyObject);
			return proxyObject;
		} else {
			return targetObject;
		}
	}

}
