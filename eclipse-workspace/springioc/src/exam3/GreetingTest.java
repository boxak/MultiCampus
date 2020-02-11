package exam3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("exam3/beans_anno.xml"); 
		System.out.println("** Container Initialization End **");
		
		LocalDateTime ldt = (LocalDateTime)factory.getBean("localtime");
		
		int hour = ldt.getHour();
		//System.out.println(hour);
		Greeting greet;
		if(hour>=6 && hour<12) {
			greet = (MorningGreetingImpl)factory.getBean("morning");
		}
		else if(hour>=12 && hour<17) {
			greet = (AfternoonGreetingImpl)factory.getBean("afternoon");
		}
		else if(hour>=17 && hour<22) {
			greet = (EveningGreetingImpl)factory.getBean("evening");
		}
		else {
			greet = (NightGreetingImpl)factory.getBean("night");
		}
		if(greet!=null) {
			greet.greet();
		}
		((ClassPathXmlApplicationContext)factory).close();
	}

}
