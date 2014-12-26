package com.mycompany.app;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AuthorizationInterceptor implements MethodInterceptor {

	private App app;

	public AuthorizationInterceptor(App authorizationService) {
		this.app = authorizationService;
	}

	/**
	 * Intercept the proxy method invocations to inject authorization check. The
	 * original method is invoked through MethodProxy.
	 * 
	 * @param object
	 *            the proxy object
	 * @param method
	 *            intercepted Method
	 * @param args
	 *            arguments of the method
	 * @param proxy
	 *            the proxy used to invoke the original method
	 * @throws Throwable
	 *             any exception may be thrown; if so, super method will not be
	 *             invoked
	 * @return any value compatible with the signature of the proxied method.
	 */
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		if (app != null) {
			// may throw an AuthorizationException if authorization failed
			app.authorize(method);
		}
		return methodProxy.invokeSuper(object, args);
	}
}
