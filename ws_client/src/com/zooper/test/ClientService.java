package com.zooper.test;

import com.zooper.ws.HelloWSImpl;
import com.zooper.ws.HelloWSImplService;

public class ClientService {
	public static void main(String[] args) {
		HelloWSImplService factory = new HelloWSImplService();
		HelloWSImpl helloWSImpl = factory.getHelloWSImplPort();
		System.out.println(helloWSImpl.getClass());
		
		String result = helloWSImpl.sayHello("zooper");
		System.out.println(result);
	}
}
