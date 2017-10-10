package com.zooper.test;

import javax.xml.ws.Endpoint;

import com.zooper.ws.HelloWSImpl;

public class ServerTest {
	public static void main(String[] args) {
		String address = "http://192.168.0.105:8989/ws/helloWorld";
		Endpoint.publish(address, new HelloWSImpl());
		System.out.println("WebService发布成功!");
	}
}
