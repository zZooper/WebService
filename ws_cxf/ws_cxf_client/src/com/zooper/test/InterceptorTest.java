package com.zooper.test;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import com.zooper.interceptor.AddUserInterceptor;
import com.zooper.ws.hellows.HelloWS;
import com.zooper.ws.hellows.HelloWSImplService;

/**
 * 客户端cxf拦截器测试类
 * @author Administrator
 *
 */
public class InterceptorTest {
	public static void main(String[] args) {
		
		System.out.println("添加入和出日志拦截器");
		HelloWSImplService factory = new HelloWSImplService();
		HelloWS helloWSImpl = factory.getHelloWSImplPort();
		
		Client client = ClientProxy.getClient(helloWSImpl);
		
		//客户端的日志入拦截器
		List<Interceptor<? extends Message>> inInterceptors = client.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		//客户端日志出拦截器
		List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		String result = helloWSImpl.sayHello("zooper");
		System.out.println(result);
		
		
		System.out.println("添加自定义出拦截器");
		outInterceptors.add(new AddUserInterceptor("xiaoming", "meiyoumima"));
		
		String result1 = helloWSImpl.sayHello("zooper");
		System.out.println(result1);
}
}
