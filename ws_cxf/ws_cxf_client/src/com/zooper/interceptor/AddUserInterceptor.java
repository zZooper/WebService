package com.zooper.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.utils.DOMHelper;
/**
 * 在请求体里面添加用户信息的拦截器
 * @author Administrator
 *
 */
public class AddUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	
	private String name;
	private String password;

	public AddUserInterceptor(String name, String password) {
		super(Phase.PRE_PROTOCOL); //准备协议化时拦截
		this.name = name;
		this.password = password;
	}
	
	/**
	 * 客户端请求服务器端的sayHello(),请求体格式
	 * 	<envolope>
	 *		<body>
	 *			<sayHello>
	 *				<arg0>zooper</arg0>
	 *			</sayHello>
	 *		</body>		
	 * 	</envolope>
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		List<Header> headers = msg.getHeaders();
		
		/*
		 * 拦截请求,在请求体<body>标签前添加<head>内容如下:
		 * <user>
		 * 		<name>xiaoming</name>
		 * 		<password>meiyoumima</password>
		 * </user>
		 */
		Document document = DOMHelper.createDocument();
		Element rootEle = document.createElement("user");
		//在user节点下添加子节点name
		Element nameEle = document.createElement("name");
		nameEle.setTextContent(name);
		rootEle.appendChild(nameEle);
		
		//在user节点下添加子节点password
		Element passwordEle = document.createElement("password");
		passwordEle.setTextContent(password);
		rootEle.appendChild(passwordEle);
		
		headers.add(new Header(new QName("user"), rootEle));
		System.out.println("client handleMessage");
		/*
		 * 此时，如果发送一个请求，那么它的请求体将是如下格式:
		 * 	<envolope>
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
		 * 注:head下可以有多个节点
		 */
	}
	
}
