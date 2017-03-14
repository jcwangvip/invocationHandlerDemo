package com.jc.business.impl;

import com.jc.business.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public int calculate(int a, int b) {
		System.out.println("这是进入业务方法后打印的");
		return a/b;
	}

}
