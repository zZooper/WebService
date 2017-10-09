开发工具: myeclipse

一、schema规范:
1.所有标签和属性都需要有schema文件来定义(xx.xsd)
2.所有的文件都需要有一个id,在这里它叫namespace
3.namespace的值由什么来指定?
	由targetNamespace属性来指定，它的值是一个url(很有可能不存在)
4.如何引入一个schema约束?
	属性? : 用xmlns属性
	属性值 : 对应的schema文件的id(namespace值) 
5.如果引入的schema不是w3c组织定义，必须指定schema文件的位置
6.schema文件的位置由什么属性来指定?
	属性? : schemaLocation
	属性值 : namespace path
7.如果引入N个约束，至少需要给n-1个取别名



二、jdk开发WebService
1、ws_server发布WebService(发布地址?wsdl : 查看wsdl文档)
2、ws_client创建客户端应用编码方式访问(进入要生成客户端代码的目录下)
	-借助jdk的wsimport.exe工具生成客户端代码
		wsimport -keep url?wsdl  //url为wsdl文件的路径
	-借助生成的代码编写请求代码
		wsimport -keep xxx.wsdl文件路径
		

三、使用cxf开发WebService
服务端 : 加入cxf的jar包即可，其它不需要改动
客户端 : 动态生成代码时,将cxf的bin目录下的wsdl2java.bat所在目录添加到环境变量path当中，
		 执行wsdl2java url?wsdl 或 wsdl2java xxx.wsdl文件路径来生成客户端代码



四、wsdl文档解析
<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" 
xmlns:wsp="http://www.w3.org/ns/ws-policy" 
xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" 
xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" 
xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" 
xmlns:tns="http://ws.zooper.com/" 
xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
xmlns="http://schemas.xmlsoap.org/wsdl/" 
targetNamespace="http://ws.zooper.com/" 
name="HelloWSImplService">

	<!-- 
		引入请求和响应的约束,内容如下
		<?xml version="1.0" encoding="UTF-8"?>
		<xs:schema targetNamespace="http://ws.zooper.com/" version="1.0" 
		xmlns:xs="http://www.w3.org/2001/XMLSchema" 
		xmlns:tns="http://ws.zooper.com/">
			<xs:element type="tns:sayHello" name="sayHello"/>
			<xs:element type="tns:sayHelloResponse" name="sayHelloResponse"/>
			<xs:complexType name="sayHello">
				<xs:sequence>
					<xs:element type="xs:string" name="arg0" minOccurs="0"/>
				</xs:sequence>
			</xs:complexType>
			<xs:complexType name="sayHelloResponse">
				<xs:sequence>
					<xs:element type="xs:string" name="return" minOccurs="0"/>
				</xs:sequence>
			</xs:complexType>
		</xs:schema>
		

		用于请求
		<sayHello>
			<arg0>String</arg0>
		</sayHello>
		
		用于响应
		<sayHelloResponse>
			<return>String</return>
		</sayHelloResponse>
	-->
	<types>
		<xsd:schema>
			<xsd:import namespace="http://ws.zooper.com/" schemaLocation="http://192.168.0.105:8989/ws/helloWorld?xsd=1"></xsd:import>
		</xsd:schema>
	</types>


	<!--
		message : 用来定义消息的结构
			part : 指定引用types中定义的标签片段
	 -->
	<message name="sayHello">
		<part name="parameters" element="tns:sayHello"></part>
	</message>
	<message name="sayHelloResponse">
		<part name="parameters" element="tns:sayHelloResponse"></part>
	</message>


	<!--
		portType : 用来定义服务器端的SEI
			operation : 用来指定SEI中的处理请求的方法
				input : 指定客户端应用传过来的数据， 会引用上面定义的<message>
				output : 指定服务器端返回给客户端的数据 ， 会引用上面定义的<message>
	-->
	<portType name="HelloWSImpl">
		<operation name="sayHello">
			<input wsam:Action="http://ws.zooper.com/HelloWSImpl/sayHelloRequest" message="tns:sayHello"></input>
			<output wsam:Action="http://ws.zooper.com/HelloWSImpl/sayHelloResponse" message="tns:sayHelloResponse"></output>
		</operation>
	</portType>


	
	<!--
		binding : 用于定义SEI的实现类
			type属性 : 引用上面的<portType>
			<soap:binding style="document"> : 绑定的数据是一个document(xml)
			operation : 用来定义实现的方法
				input : 指定客户端应用传过来的数据
					<soap:body use="literal"> : 文本数据
				output : 指定服务端返回给客户端的数据
					<soap:body use="literal"> : 文本数据
				
	-->
	<binding name="HelloWSImplPortBinding" type="tns:HelloWSImpl">
		<soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"></soap:binding>
		<operation name="sayHello">
			<soap:operation soapAction=""></soap:operation>
			<input>
				<soap:body use="literal"></soap:body>
			</input>
			<output>
				<soap:body use="literal"></soap:body>
			</output>
		</operation>
	</binding>


	
	<!--
		service : 一个WebService的容器
			name属性 : 它用于指定客户端容器类
			port : 用来指定服务器端处理请求的入口(SEI的实现)
				bingding属性 : 引用上面定义的<binding>
				address : 当前WebService的发布地址
	-->
	<service name="HelloWSImplService">
		<port name="HelloWSImplPort" binding="tns:HelloWSImplPortBinding">
			<soap:address location="http://192.168.0.105:8989/ws/helloWorld"></soap:address>
		</port>
</service>
</definitions>