package com.jc.test;

import com.jc.business.Calculator;
import com.jc.business.impl.CalculatorImpl;
import com.jc.testjdkproxy.JdkProxy;

public class TestJdkProxy {

	public static void main(String[] args) {

		Calculator calculator = new CalculatorImpl();
		JdkProxy jdkProxy = new JdkProxy(calculator);
		Calculator proxy = (Calculator) jdkProxy.getProxy();
		
		int res = proxy.calculate(4, 2);
		
		System.out.println(res);
		
	}

}
