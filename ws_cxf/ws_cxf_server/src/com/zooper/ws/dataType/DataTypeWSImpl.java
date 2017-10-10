package com.zooper.ws.dataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.zooper.ws.bean.Student;

@WebService
public class DataTypeWSImpl implements DataTypeWS{

	@Override
	public boolean addStudent(Student stu) {
		System.out.println("server addstudent() " + stu);
		return true;
	}

	@Override
	public Student getStudentById(int id) {
		System.out.println("server getStudentById() " + id);
		return new Student(id, "alice", "女");
	}

	@Override
	public List<Student> getStudentBySex(String sex) {
		System.out.println("server getStudentBySex() " + sex);
		
		Student stu = new Student(1, "tom", sex);
		Student stu1 = new Student(2, "bob", sex);
		Student stu2 = new Student(3, "cat", sex);

		List<Student> list = new ArrayList<>();
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
		
		return list;
	}

	@Override
	public Map<Integer, Student> getAllStudentsMap() {
		System.out.println("server getAllStudentsMap()");
		
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "tom", "男"));
		map.put(2, new Student(2, "bob", "男"));
		map.put(3, new Student(3, "cat", "女"));
		return map;
	}
	
	
}
