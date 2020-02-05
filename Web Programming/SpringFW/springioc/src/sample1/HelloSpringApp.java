﻿package sample1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloSpringApp {
	public static void main(String[] args) {
		ApplicationContext factory
		    	= new ClassPathXmlApplicationContext("sample1/beans.xml");
		//src 폴더를 기준으로 path를 찾아서 ApplicationContext 객체를 생성한다.
		System.out.println("**** Container Initialization End ****");
		
		MessageBean bean=(MessageBean)factory.getBean("messageBean");
		bean.sayHello();                 
		bean.sayHello("banana", 1500);   
		System.out.println(bean);
		System.out.println(factory.getBean("messageBean")); //getBean -> Lookup 방식.
		System.out.println(factory.getBean("messageBean")); //
		((ClassPathXmlApplicationContext)factory).close();
	}
}





