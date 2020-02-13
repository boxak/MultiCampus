package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController{
	@RequestMapping("/edu")
	public ModelAndView returnScore(int score) {
		//return형을 안주고 void형으로 해주면 edu.jsp가 응답한다.
		ModelAndView mav = new ModelAndView();
		//System.out.println("이름 : "+name+", 평균점수 : "+score);
		//mav.addObject("spring",name);
		
		if(score>=90) {
			mav.setViewName("gradeA");
		}
		else if(score>=80) {
			mav.setViewName("gradeB");
		}
		else if(score>=70) {
			mav.setViewName("gradeC");
		}
		else {
			mav.setViewName("gradeD");
		}
		return mav;
	}
}