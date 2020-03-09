package my.spring.springnews;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.LoginDAO;
import vo.LoginVO;

@Controller
public class LoginController {
	@Autowired
	LoginDAO dao;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doPost(@RequestParam("mem_userid")String mem_userid,
			@RequestParam("mem_password")String mem_password,
			HttpSession session) {
		LoginVO vo = dao.getVO(mem_userid);
		String password;
		if(vo==null) {
			session.setAttribute("msg", "존재하지 않는 아이디입니다!");
			return "LoginError";
		}
		else {
			password = vo.getMem_password();
			if(!password.equals(mem_password)) {
				session.setAttribute("msg", "비밀번호가 일치하지 않습니다!");
				return "LoginError";
			}
			else {
				session.setAttribute("loginVO", vo);
				return "redirect:http://localhost:8000/springnews/jobad";
			}
		}
	}
}
