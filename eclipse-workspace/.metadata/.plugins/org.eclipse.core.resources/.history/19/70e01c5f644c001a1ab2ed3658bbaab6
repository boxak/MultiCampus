package my.spring.springedu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
			,int cnt1,int cnt2,int cnt3,HttpSession s, HttpServletRequest req) {
		vo.setCnt1(cnt1);
		vo.setCnt2(cnt2);
		vo.setCnt3(cnt3);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productView");
		return mav;
	}
	@RequestMapping("/productreset")
	public 
}
