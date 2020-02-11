package my.spring.springedu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.LottoService;
import vo.LottoVO;
@Controller
public class LottoController1 {
	@Autowired
	//Autowired 라고 되어있는 부분은 LottoController가 호출되면 객체 생성된다.
	//즉, LottoController 객체 생성하려면 먼저 LottoService가 호출되어야하므로
	//LottoService 객체에 의존적이다.
	private LottoService lottoService;	
	@RequestMapping("/lotto1")
	public String lottoProcess(LottoVO vo) {		
		if (lottoService.getLottoProcess(vo.getLottoNum())) {
			vo.setResult("추카추카!!");
		} else {
			vo.setResult("아쉽네요 .. 다음 기회를!!");
		}
		return "lottoView1";
	}
}



