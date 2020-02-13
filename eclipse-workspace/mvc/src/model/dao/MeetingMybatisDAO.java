package model.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.vo.MeetingVO;
import model.vo.VisitorVO;

public class MeetingMybatisDAO implements MeetingDAO{
	final String resource = "resource/mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory = null;
	public MeetingMybatisDAO() {
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MeetingVO> listAll(){
		System.out.println("Mybatis 를 사용 DB 연동-listAll(MeetingMybatisDAO)");
		List<MeetingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
		System.out.println(session.getClass().getName());
		session.close();
		return list;
	}
	
	public List<MeetingVO> search(String keyword){
		System.out.println("Mybatis 를 사용 DB 연동-search(MeetingMybatisDAO)");
		List<MeetingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement);
		System.out.println(session.getClass().getName());
		session.close();
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-insert(MeetingMybatisDAO)");
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) == 1) {
			flag = true;
		}
		session.close();
		return flag;
	}
	
	public boolean delete(int id) {
		System.out.println("Mybatis 를 사용 DB 연동-delete(MeetingMybatisDAO)");
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) == 1) {
			flag = true;
		}
		session.close();
		return flag;
	}
	
	public boolean update(int id) {
		System.out.println("Mybatis 를 사용 DB 연동-update(MeetingMybatisDAO)");
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, id)==1) {
			flag = true;
		}
		session.close();
		return flag;
	}
}
