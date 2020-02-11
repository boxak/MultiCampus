package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.MemberVO;

@Controller
public class MemberController{
	@RequestMapping("/member")
	public String handle(@ModelAttribute("info")MemberVO vo) {
		return "memberView";
	}
}


