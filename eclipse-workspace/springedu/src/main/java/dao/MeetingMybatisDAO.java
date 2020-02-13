package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MeetingVO;

@Repository
public class MeetingMybatisDAO implements MeetingDAO{
	final String resource = "resource/mybatis-config.xml";
	@Autowired
	SqlSession session;
	
	public List<MeetingVO> listAll(){
		System.out.println("Mybatis 를 사용 DB 연동-listAll(MeetingMybatisDAO)");
		List<MeetingVO> list = null;
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
		System.out.println(session.getClass().getName());
		return list;
	}
	
	public List<MeetingVO> search(String keyword){
		System.out.println("Mybatis 를 사용 DB 연동-search(MeetingMybatisDAO)");
		List<MeetingVO> list = null;
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement);
		System.out.println(session.getClass().getName());
		return list;
	}
	
	public boolean insert(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-insert(MeetingMybatisDAO)");
		boolean flag = false;
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) == 1) {
			flag = true;
		}
		return flag;
	}
	
	public boolean delete(int id) {
		System.out.println("Mybatis 를 사용 DB 연동-delete(MeetingMybatisDAO)");
		boolean flag = false;
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) == 1) {
			flag = true;
		}
		return flag;
	}
	
	public boolean update(int id) {
		System.out.println("Mybatis 를 사용 DB 연동-update(MeetingMybatisDAO)");
		boolean flag = false;
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, id)==1) {
			flag = true;
		}
		return flag;
	}
}
