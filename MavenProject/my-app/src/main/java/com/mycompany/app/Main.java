package com.mycompany.app;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class Main {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestTargetObj.class);
		App app = new App();
		enhancer.setCallback(new AuthorizationInterceptor(app));
		Object o = enhancer.create();
		
		if(o instanceof TestTargetObj)
		{
			TestTargetObj t = (TestTargetObj) o;
			t.sayHello();
		}
	}
}
