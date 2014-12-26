package com.mycompany.app;

import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public void authorize(Method method) {
		// TODO Auto-generated method stub
		System.out.println("this is interceptor");
	}
}
