package my.spring.springedu;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//POJO 클래스라고 한다.
public class HelloController {	
	 
	public HelloController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/hello")
	public ModelAndView xxx(){		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloView");
		mav.addObject("msg", getMessage());
		//setAttribute 와 거의 같은 역할.
		return mav;
	}
	private String getMessage(){
		int hour = Calendar.getInstance()
				.get(Calendar.HOUR_OF_DAY);		
		if(hour >= 6 && hour <= 10){
			return "Good Morning!!";
		}else if(hour >= 12 && hour <= 15){
			return "Good Afternoon";
		}else if(hour >= 18 && hour <= 22){
			return "Good Evening!!";
		}else{ 
			return "Hello!!";
		}
	}
}




