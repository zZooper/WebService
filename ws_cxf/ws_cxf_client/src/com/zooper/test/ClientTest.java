package com.zooper.test;

import java.util.List;

import com.zooper.ws.datatype.DataTypeWS;
import com.zooper.ws.datatype.DataTypeWSImplService;
import com.zooper.ws.datatype.GetAllStudentsMapResponse.Return;
import com.zooper.ws.datatype.GetAllStudentsMapResponse.Return.Entry;
import com.zooper.ws.datatype.Student;
import com.zooper.ws.hellows.HelloWS;
import com.zooper.ws.hellows.HelloWSImplService;

public class ClientTest {
	public static void main(String[] args) {
		//调用helloWS服务
		HelloWSImplService factory = new HelloWSImplService();
		HelloWS helloWSImpl = factory.getHelloWSImplPort();
		System.out.println(helloWSImpl.getClass());
		
		String result = helloWSImpl.sayHello("zooper");
		System.out.println(result);
		
		//调用dataType服务
		DataTypeWSImplService dataTypeFactory = new DataTypeWSImplService();
		DataTypeWS dataTypeWS = dataTypeFactory.getDataTypeWSImplPort();
		
		boolean success = dataTypeWS.addStudent(new Student(1, "Tom", "男"));
		System.out.println(success);
		
		Student stu1 = dataTypeWS.getStudentById(1);
		System.out.println(stu1);
		
		List<Student> stuList = dataTypeWS.getStudentBySex("男");
		System.out.println(stuList);
		
		Return r = dataTypeWS.getAllStudentsMap();
		List<Entry> entrys = r.getEntry();
		for (Entry entry : entrys) {
			Student student = entry.getValue();
			System.out.println(student);
		}
	}
}
