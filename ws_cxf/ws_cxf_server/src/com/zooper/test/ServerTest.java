package com.zooper.test;

import javax.xml.ws.Endpoint;
import com.zooper.ws.dataType.DataTypeWSImpl;
import com.zooper.ws.hellows.HelloWSImpl;

public class ServerTest {
	public static void main(String[] args) {
		String helloWorldAddress = "http://192.168.0.105:8989/ws/helloWorld";
		String dataTypeAddress = "http://192.168.0.105:8989/ws/dataType";
		Endpoint.publish(helloWorldAddress, new HelloWSImpl());
		Endpoint.publish(dataTypeAddress, new DataTypeWSImpl());
		
		System.out.println("WebService发布成功!");
	}
}
