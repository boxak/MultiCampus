package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;

@Repository
public class NewsDAO {
	final String resource = "resource/mybatis-config.xml";
	@Autowired
	SqlSession session;
	
	public boolean insert(NewsVO vo) {
		System.out.println("springnews - News - insert");
		boolean flag = false;
		String statement = "resource.NewsMapper.insertNews";
		if(session.insert(statement, vo) == 1) {
			flag = true;
		}
		return flag;
	}
	public boolean update(NewsVO vo) {
		System.out.println("springnews - News - update");
		boolean flag = false;
		String statement = "resource.NewsMapper.updateNews";
		if(session.update(statement, vo) == 1) {
			flag = true;
		}
		return flag;
	}
	public boolean delete(int id) {
		System.out.println("springnews - News - delete");
		boolean flag = false;
		String statement = "resource.NewsMapper.deleteNews";
		if(session.delete(statement, id)==1) {
			flag = true;
		}
		return flag;
	}
	public List<NewsVO> listAll(){
		System.out.println("springnews - News - listAll");
		String statement = "resource.NewsMapper.selectNews";
		List<NewsVO> list = session.selectList(statement);
		return list;
	}
	public NewsVO listOne(int id) {
		System.out.println("springnews - News - listOne");
		String statement = "resource.NewsMapper.listOneNews";
		NewsVO vo = session.selectOne(statement,id);
		System.out.println("조회수 : "+vo.getCnt());
		update(vo);
		return vo;
	}
	public List<NewsVO> listWriter(String Writer){
		System.out.println("springnews - News - listWriter");
		String statement = "resource.NewsMapper.listWriterNews";
		List<NewsVO> list = session.selectList(statement,Writer);
		return list;
	}
	public List<NewsVO> search(String key, String searchType){
		System.out.println("springnews - News - search");
		String statement = "resource.NewsMapper.searchNews";
		Map<String, String> map = new HashMap<>();
		map.put("searchType",searchType);
		map.put("key", key);
		System.out.println(map);
		List<NewsVO> list = session.selectList(statement, map);
		for(NewsVO vo : list) {
			System.out.println(vo);
		}
		return list;
	}
}
