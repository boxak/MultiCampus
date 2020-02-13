﻿package sampleanno04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Engineer {
	//@Autowired
	//@Qualifier("emp1")
	//emp 객체면 emp1이 등록된다. Qualifier는 Autowired의 서브역할.
	@Resource(name="emp1")
	//Resource는 java 애노테이션임.
	private Emp emp;
	//두 개이상일 때는 emp으로 등록된다.
	private String dept;
	
	public Engineer() {
		super();
	}
	@Autowired
	public void ddd(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString()+"\n"+ "and works at the "+dept+" department.";
	}
}







