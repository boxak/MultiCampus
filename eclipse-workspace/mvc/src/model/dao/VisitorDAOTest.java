package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.VisitorVO;
import static org.junit.jupiter.api.Assertions.*;
//static import 구문을 쓰면 class 이름을 안주고 메서드를 쓸 수 있다. static 메서드들.
import static java.lang.System.out;
//이러면 out을 System을 안붙이고 쓸 수 있다.

class VisitorDAOTest {

	@Test
	void test() {
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.listAll();
		System.out.println(list.size());
		for(VisitorVO vo:list) {
			System.out.println(vo);
		}
	}
	
	@Test
	void test1() {
		System.out.println("검색 기능 테스트");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search(" ");
		System.out.println(list.size());
		for(VisitorVO vo:list) {
			System.out.println(vo);
		}
	}
	
	@Test
	void test2() {
		System.out.println("삽입 테스트");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("희동이");
		vo.setMemo("~~~오늘은 그냥 금요일~~~");
		boolean result = dao.insert(vo);
		if(result) {
			System.out.println("삽입 성공");
		}
		else {
			fail("삽입 실패");
		}
	}

}
