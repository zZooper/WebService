package com.zooper.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * 检查用户的拦截器
 * @author Administrator
 *
 */
public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	public CheckUserInterceptor(){
		super(Phase.PRE_PROTOCOL);
	}
	
	/**
	 * 客户端请求体格式:
	 * <envolope>
	 * 		<head>
	 * 			<user>
	 * 				<name>xiaoming</name>
	 * 				<password>meiyoumima</password>
	 * 			</user> 			
	 * 		</head>
	 *		<body>
	 *			<sayHello>
	 *				<arg0>zooper</arg0>
	 *			</sayHello>
	 *		</body>		
	 * 	</envolope>  
	 * 
	 * 注: <head>是客户端拦截器拦截请求时加上的用户信息,一般请求是没有<head>的
	 */
	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		Header header = msg.getHeader(new QName("user"));
		
		if(header != null ){
			Element user = (Element) header.getObject();
			//获取节点name和password的值
			String name = user.getElementsByTagName("name").item(0).getTextContent();
			String password = user.getElementsByTagName("password").item(0).getTextContent();
			if("xiaoming".equals(name) && "meiyoumima".equals(password)){
				System.out.println("Server通过拦截器...");
				return;
			}else{
				//不能通过
				System.out.println("Server不能通过....");
				throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码"));
			}
		}
		
	}
}
