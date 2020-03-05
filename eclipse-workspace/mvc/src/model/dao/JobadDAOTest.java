package model.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.JobadVO;

class JobadDAOTest {

	@Test
	void test() {
		System.out.println("삽입 테스트");
		JobadDAO dao = new JobadDAO();
		JobadVO vo = new JobadVO();
		vo.setMem_userid("boxak");
		vo.setMem_username("황지원");
		vo.setPost_title("두번째");
		vo.setPost_content("게시판 첫 글입니다.");
		vo.setPost_location("서울특별시 강남구 역삼동 788-28");
		vo.setPost_payment(10000);
		vo.setPost_phone("010-2239-1506");
		boolean result = dao.insert(vo);
		if(result) {
			System.out.println("삽입 성공");
		}
		else {
			fail("삽입 실패");
		}
		System.out.println("-----------------");
	}
	
	@Test
	void test2() {
		System.out.println("읽기 기능 테스트");
		JobadDAO dao = new JobadDAO();
		List<JobadVO> list = dao.listAll(1);
		System.out.println(list.size());
		for(JobadVO vo : list) {
			System.out.println(vo.toString());
		}
	}
	
	@Test
	void test3() {
		System.out.println("검색 기능 테스트");
		JobadDAO dao = new JobadDAO();
		List<JobadVO> list = dao.search("두", "title", 1);
		for(JobadVO vo : list) {
			System.out.println(vo.toString());
		}
	}

}
