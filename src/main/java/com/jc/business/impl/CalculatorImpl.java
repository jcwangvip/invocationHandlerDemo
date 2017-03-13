package com.jc.business.impl;

import com.jc.business.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public int calculate(int a, int b) {
		return a/b;
	}

}
