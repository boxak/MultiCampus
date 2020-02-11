package my.spring.springedu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import vo.ProductVO;

@Controller
@SessionAttributes({"product"})
public class ProductController {
	@ModelAttribute("product")
	public ProductVO returnProduct() {
		System.out.println("returnProduct 호출");
		return new ProductVO();
	}
	@RequestMapping("/product")
	public ModelAndView handle(@ModelAttribute("product")ProductVO vo
			,String cnt1,String cnt2,String cnt3,HttpSession s, HttpServletRequest req) {
		if(cnt1!=null && cnt1.equals("")) {
			vo.setCnt1(Integer.parseInt(cnt1));
		}
		if(cnt2!=null && cnt2.equals("")) {
			vo.setCnt1(Integer.parseInt(cnt2));
		}
		if(cnt3!=null && cnt3.equals("")) {
			vo.setCnt1(Integer.parseInt(cnt3));
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productView");
		return mav;
	}
	@RequestMapping("/productreset")
	public void handle(SessionStatus s) {
		s.setComplete();
		System.out.println("Products are deleted!");	
		System.out.println("=============================");
	}
}
