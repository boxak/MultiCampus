package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

	public static void main(String[] args) {
		
		ApplicationContext factory1 =
				new ClassPathXmlApplicationContext("exam2/bean1.xml");
		
		Student st1 = (Student)factory1.getBean("st1");
		Student st2 = (Student)factory1.getBean("st2");
		Student st3 = (Student)factory1.getBean("st3");
		
		System.out.println("Result From Bean1");
		System.out.println(st1.getName()+"는 "+st1.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println(st2.getName()+"는 "+st2.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println(st3.getName()+"는 "+st3.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println();
		
		((ClassPathXmlApplicationContext)factory1).close();
		
		ApplicationContext factory2 =
				new ClassPathXmlApplicationContext("exam2/bean2.xml");
		
		st1 = (Student)factory2.getBean("st1");
		st2 = (Student)factory2.getBean("st2");
		st3 = (Student)factory2.getBean("st3");
		
		System.out.println("Result From Bean2");
		System.out.println(st1.getName()+"는 "+st1.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println(st2.getName()+"는 "+st2.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println(st3.getName()+"는 "+st3.getMyHomework().getHomeworkName()+"를 학습합니다.");
		System.out.println();
		
		((ClassPathXmlApplicationContext)factory2).close();
	}

}
