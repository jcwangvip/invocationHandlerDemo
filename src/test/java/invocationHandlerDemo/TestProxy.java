package invocationHandlerDemo;

import java.util.ArrayList;
import java.util.List;

import com.jc.aop.AbstractHandler;
import com.jc.aop.AfterHandler;
import com.jc.aop.BeforeHandler;
import com.jc.aop.impl.AfterHandlerImpl;
import com.jc.aop.impl.BeforeHandlerImpl;
import com.jc.business.Calculator;
import com.jc.business.impl.CalculatorImpl;
import com.jc.factory.ProxyFactory;

public class TestProxy {

	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
		BeforeHandler beforeHandler = new BeforeHandlerImpl();
		AfterHandler afterHandler = new AfterHandlerImpl();
		handlers.add(beforeHandler);
		handlers.add(afterHandler);
		
		
		Calculator proxy = (Calculator) ProxyFactory.getProxy(calculator, handlers);
		
		int res = proxy.calculate(20, 10);
		System.out.println(res);

	}
}
