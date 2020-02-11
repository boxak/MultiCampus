package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController{
	@RequestMapping("/member")
	public ModelAndView returnVO(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		System.out.println(vo.getName());
		mav.addObject("info",vo);
		mav.setViewName("memberView");
		return mav;
	}
}


