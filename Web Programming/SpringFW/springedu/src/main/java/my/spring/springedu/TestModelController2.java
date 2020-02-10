package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestModelController2 {
	@ModelAttribute("data1")
	public int createModel1() {	
		System.out.println("createModel() call - data1");
		return 100;
	}
	@ModelAttribute("data2")
	public int createModel2() {	
		System.out.println("createModel() call - data2");
		return 200;
	}
	@RequestMapping(value="/testmodel2")
	public String handle(@ModelAttribute("data1") int vo1, 
			      @ModelAttribute("data2") int vo2) {
		//vo1 = 100, vo2 = 200으로 보관된다.
		//클라이언트가 vo1 = 1000, vo2 = 2000으로 줘도 이 요청은 무시된다.
		System.out.println("handle() : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}


