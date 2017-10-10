package com.zooper.ws.hellows;

import javax.jws.WebService;

@WebService
public interface HelloWS {
	
	public String sayHello(String name);
	
}
