package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.NewsVO;

class NewsDAOTest {

	@Test
	void test() {
		NewsVO vo = new NewsVO();
		vo.setWriter("황지원");
		vo.setTitle("News 첫번째 글");
		vo.setContent("첫번째 글의 테스트 문서입니다.");
		NewsDAO nd = new NewsDAO();
		List<NewsVO> list = new ArrayList<>();
		//System.out.println("삽입 : "+nd.insert(vo));
		
		list = nd.listAll();
		System.out.println(list.size());
		for(NewsVO data : list) {
			System.out.println(data);
		}
		/*
		vo.setId(5);
		vo.setContent("첫번째 글을 수정했습니다.");
		System.out.println("수정 : "+nd.update(vo));
		list = nd.listAll();
		for(NewsVO data : list) {
			System.out.println(data);
		}*/
		/*
		System.out.println("삭제 : "+nd.delete(5));
		list = nd.listAll();
		for(NewsVO data : list) {
			System.out.println(data);
		}*/
		
		NewsVO vo1 = new NewsVO();
		vo1 = nd.listOne(9);
		System.out.println(vo1);
		
	}

}
