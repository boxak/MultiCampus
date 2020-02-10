package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController{
	@RequestMapping("/calc")
	public ModelAndView returnCalc(String num1,String num2,String operator) {
		ModelAndView mav = new ModelAndView();
		String errorMsg = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
		int n1 = 0;
		int n2 = 0;
		int result = 0;
		if(num1!=null && num2!=null) {
			n1 = Integer.parseInt(num1);
			n2 = Integer.parseInt(num2);
			if(operator.equals("/") && n2==0){
				mav.addObject("errorMsg",errorMsg);
				mav.setViewName("errorResult");
			}
			else {
				//Spring MVC가 java 1.6 기반으로 되어 있어서 컴파일도 1.6버전으로 실행한다.
				//POM.xml도 자바 버전을 1.8로 바꾸고, Project Facets에 들어가서도 자바 버전을 1.8로 바꾸어야 한다.
				switch(operator) {
					case "+":
						result = n1+n2;
						break;
					case "-" :
						result = n1-n2;
						break;
					case "*" :
						result = n1*n2;
						break;
					case "/" :
						result = n1/n2;
						break;
				}
				
				mav.addObject("result",result);
				mav.setViewName("calcResult");
			}
		}
		return mav;
	}
}


