package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.CalcVO;

@Controller
public class CalcController{
	@RequestMapping("/calc")
	public String handle(@ModelAttribute("calculation")CalcVO vo) {
		if(vo.getOperator().equals("/") && vo.getNum2()==0) {
			vo.setErrorMsg("두번째 숫자를 0이면 나눗셈을 할 수 없습니다!");
			return "errorResult";
		}
		else {
			switch(vo.getOperator()) {
				case "+" : 
					vo.setResult(vo.getNum1()+vo.getNum2());
					break;
				case "-" :
					vo.setResult(vo.getNum1()-vo.getNum2());
					break;
				case "*" : 
					vo.setResult(vo.getNum1()*vo.getNum2());
					break;
				case "/" : 
					vo.setResult(vo.getNum1()/vo.getNum2());
					break;
			}
			return "calcResult";
		}
	}
}


