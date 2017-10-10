package com.zooper.ws.dataType;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.zooper.ws.bean.Student;

/**
 * 测试返回不同的数据类型
 * @author Administrator
 *
 */
@WebService
public interface DataTypeWS {
	@WebMethod
	public boolean addStudent(Student stu);
	
	@WebMethod
	public Student getStudentById(int id);
	
	@WebMethod
	public List<Student> getStudentBySex(String sex);
	
	@WebMethod
	public Map<Integer,Student> getAllStudentsMap();
}
