package my.spring.springedu;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.LottoService;
import vo.LottoVO;
@Controller
public class LottoController2 {
	@Autowired
	//Autowired 라고 되어있는 부분은 LottoController가 호출되면 객체 생성된다.
	//즉, LottoController 객체 생성하려면 먼저 LottoService가 호출되어야하므로
	//LottoService 객체에 의존적이다.
	private LottoService lottoService;	
	@RequestMapping("/lotto2")
	public String lottoProcess(LottoVO vo,HttpSession s) {
		
		if(s.getAttribute("lottocnt")==null) {
			s.setAttribute("lottocnt", new int[1]);
		}
		int lottocnt[] = (int [])s.getAttribute("lottocnt");
		lottocnt[0]++;
		System.out.println(lottocnt[0]);
		if (lottoService.getLottoProcess(vo.getLottoNum())) {
			lottocnt[0]=3;
			vo.setResult("추카추카!!");
		} else {
			vo.setResult("아쉽네요 .. 다음 기회를!!");
		}
		if(lottocnt[0]>=4) {
			//System.out.println("HERE");
			vo.setResult("더 이상 응모할 수 없습니다. 브라우저를 재기동해주세요.");
		}
		s.setAttribute("lottocnt", lottocnt);
		return "lottoView2";
	}
}



