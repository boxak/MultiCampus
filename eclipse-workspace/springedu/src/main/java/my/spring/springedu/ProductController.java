package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	public String handle(@ModelAttribute("product")ProductVO vo) {
		//쿼리문자열과 동일한 멤버의 setter 메서드를 호출.
		//null이면 호출 안하고, null이 아니면 호출해줌.
		return "productView";
	}
	@RequestMapping("/productreset")
	public String handle(SessionStatus s) {
		s.setComplete();
		System.out.println("Products are deleted!");	
		System.out.println("=============================");
		return "response";
	}
}
