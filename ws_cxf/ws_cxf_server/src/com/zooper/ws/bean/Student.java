package com.zooper.ws.bean;


public class Student {
	private int id;
	private String name;
	private String sex;
	
	/**
	 * Student类无参的构造方法必须显示的声明，cxf是通过反射机制加载类的，
	 * 如果没有显示声明无参的构造方法
	 * 客户端传递一个Student对象，在创建对象时会报错
	 */
	public Student() {
		super();
	}

	public Student(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
