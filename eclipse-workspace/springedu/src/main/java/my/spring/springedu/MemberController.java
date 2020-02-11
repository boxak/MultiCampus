package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController{
	@RequestMapping("/member")
	public ModelAndView returnVO(MemberVO vo) {
		//vo클래스 -> 커맨드 객체.
		ModelAndView mav = new ModelAndView();
		if(vo.getName().equals("") || vo.getName()==null) {
			vo.setName("없음");
		}
		if(vo.getTelNumber().equals("") || vo.getTelNumber()==null) {
			vo.setTelNumber("없음");
		}
		if(vo.getEmail().equals("") || vo.getEmail()==null) {
			vo.setEmail("없음");
		}
		if(vo.getPw().equals("") || vo.getPw()==null) {
			vo.setPw("없음");
		}
		mav.addObject("info",vo);
		mav.setViewName("memberView");
		return mav;
	}
}


