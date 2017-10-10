package com.zooper.test;

import java.util.List;






import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import com.zooper.interceptor.CheckUserInterceptor;
import com.zooper.ws.hellows.HelloWSImpl;
/**
 * cxf拦截器测试类
 * @author Administrator
 *
 */
public class InterceptorTest {
	public static void main(String[] args) {
		String helloWorldAddress = "http://192.168.0.105:8989/ws/helloWorld";
		EndpointImpl endPointIml = (EndpointImpl) EndpointImpl.publish(helloWorldAddress, new HelloWSImpl());
		
		//服务器端的日志入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endPointIml.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		//服务器端日志出拦截器
		List<Interceptor<? extends Message>> outInterceptors = endPointIml.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		//自定义入拦截器
		inInterceptors.add(new CheckUserInterceptor());
		
		
		System.out.println("发布WebService成功!");
	}
}
