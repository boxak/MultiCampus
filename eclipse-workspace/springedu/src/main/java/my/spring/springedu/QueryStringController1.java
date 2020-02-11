package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class QueryStringController1 {
	@RequestMapping("/querystring1")
	//이렇게 선언만 되어있어도 name으로 주는 쿼리문자열을 추출해낸다.
	public ModelAndView proc(String name) {
		ModelAndView mav = new ModelAndView();
		System.out.println("["+name+"]");
		mav.addObject("spring", name);
		mav.setViewName("queryView1");
		return mav;
	}	
	@RequestMapping("/querystring2")
	//proc 메서드의 매개변수가 int형이므로 null값을 받을 수 없기 때문에 쿼리문자열을 안 주면 에러가 난다.
	public ModelAndView proc(int number) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", number);
		mav.setViewName("queryView1");
		return mav;
	}	
	@RequestMapping("/querystring3")
	public ModelAndView proc(String name, 
			                   @RequestParam("num")int number) {
		//쿼리 문자열 = 파라미터. number말고 num이라는 이름으로 전달해달라는 뜻.
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name+":"+number);
		mav.setViewName("queryView1");
		return mav;
	}
	@RequestMapping("/querystring4")
	public ModelAndView proc(
	@RequestParam("myname1") String name1,
	@RequestParam(value="myname2", required=false) String name2,
	//required = true 이면 반드시 쿼리문자열을 name2로 줘야한다. false면 null이라도 전달이 된다.
	@RequestParam(defaultValue="10") int number1, 
	//number1이라는 이름의 쿼리 문자열이 안오면, 10이라는 기본 값으로 설정된다.
	@RequestParam(value="NUM2", defaultValue="100")int number2){
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name1+":"+(number1 + number2) 
				+":"+name2);
		mav.setViewName("queryView1");
		return mav;
	}
}






