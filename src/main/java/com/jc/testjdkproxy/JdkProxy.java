package com.jc.testjdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author asdc
 * JDK代理类	
 */
public class JdkProxy implements InvocationHandler{

	 // 目标对象   
    private Object target;  
      
    /** 
     * 构造方法 
     * @param target 目标对象  
     */  
    public JdkProxy(Object target) {  
        super();  
        this.target = target;  
    }  
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		// 在目标对象的方法执行之前简单的打印一下  
        System.out.println("------------------before------------------");  
          
        /**
         * 这里公式是，方法.invork(实际的目标对象,方法参数);
         * 如果写成Object obj = method.invoke(proxy, args);程序就会一直调用本类的invoke方法，直到报错
         */
        // 执行目标对象的方法  
        //Object obj = method.invoke(proxy, args);
        Object obj = method.invoke(target, args);
          
        // 在目标对象的方法执行之后简单的打印一下  
        System.out.println("-------------------after------------------");  
		return obj;
	}
	
	/** 
     * 获取目标对象的代理对象 
     * @return 代理对象 
     * @param loader - 定义代理类的类加载器
     * @param interfaces - 代理类要实现的接口列表
     * @param h - 指派方法调用的调用处理程序 
     */
    public Object getProxy() {  
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),   
                target.getClass().getInterfaces(), this);  
    }  
    

}
