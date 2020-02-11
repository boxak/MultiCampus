package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.StepVO;
// POJO
@Controller
public class StepController {		
	@RequestMapping(value="/step",
			 method=RequestMethod.POST)
	public String memberHandle(@ModelAttribute("kkk") StepVO vo) {
		//원래는 stepVO로 저장되지만 사용자가 원하는 이름으로 꺼내게 할 수 있는 어노테이션임.
		if(vo.getAge() < 18)
			return "redirect:/resources/stepForm.html";
		//기본적으로 mvc는 forward방식으로 보내주는데, 요청 재지정을 redirect로 
		//이렇게 바꿀 수 있다.
		//jsp 외에 html에 요청해주고 싶을 때 사용.
		System.out.println("[ Information for the passed Command object ]");
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		System.out.println(vo.getAge());
		return  "stepOutput";
	}
}
