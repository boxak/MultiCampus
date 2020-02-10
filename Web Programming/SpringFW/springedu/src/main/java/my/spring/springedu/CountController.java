package my.spring.springedu;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vo.CountVO;
@Controller 
@SessionAttributes({"count1", "count2"})
//count1, count2 둘 다 세션 스코프에 보관하겠다.
//해당 객체를 리턴하는 메서드를 만든다.
public class CountController {
	@ModelAttribute("count1")
	public CountVO countMethod1() {	
		System.out.println("countMethod1 호출 - count1");
		return new CountVO();
	}
	@ModelAttribute("count2")
	public CountVO countMethod2() {
		System.out.println("countMethod2 호출 - count2");		
		return new CountVO();
	}	
	@RequestMapping(value="/count")
	//매핑명이랑 똑같은 이름의 jsp를 찾아서 들어간다!!
	public void handle(@ModelAttribute("count1")CountVO vo1, 
			      @ModelAttribute("count2")CountVO vo2, int num1, int num2, HttpSession s, HttpServletRequest req) {
		vo1.setCountNum(num1);
		vo2.setCountNum(num2);
		System.out.println("handle() : "+ 
			      vo1.getCountNum() + " : " + vo2.getCountNum());
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel")
	public void handle(SessionStatus s) {
		//SessionStatus : Spring에서 제공하는 클래스
		s.setComplete();
		//setComplete -> 세션 객체는 남겨두지만, 그 안에 있던 정보들을 다 날려버린다.
		//선별해서 지우지는 못한다. 일부만 지우고 싶을 땐 적합하지 않음.
		System.out.println("Both count1 and count2 deleted!");	
		System.out.println("=============================");
	}
}



