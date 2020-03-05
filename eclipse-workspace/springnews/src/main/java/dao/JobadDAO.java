package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.JobadVO;

@Repository
public class JobadDAO {
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","javas","1234");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	private void close(Connection conn, Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean insert(JobadVO vo) {
		boolean flag = false;
		PreparedStatement stmt = null;
		Connection conn = getConnection();
		try {
			String statement = "insert into jobad values " + "(jobad_seq.nextval,?,?,?,?,sysdate,0,?,?,?,0)";
			stmt = conn.prepareStatement(statement);
			stmt.setString(1, vo.getMem_userid());
			stmt.setString(2, vo.getMem_username());
			stmt.setString(3, vo.getPost_title());
			stmt.setString(4, vo.getPost_content());
			stmt.setString(5, vo.getPost_location());
			stmt.setInt(6, vo.getPost_payment());
			stmt.setString(7,vo.getPost_phone());
			int result = stmt.executeUpdate();
			if(result == 1) {
				flag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,null);
		}
		return flag;
	}
	public boolean update(JobadVO vo) {
		boolean flag = false;
		PreparedStatement stmt = null;
		Connection conn = getConnection();
		try {
			
			String statement = "update jobad set mem_userid =?, mem_username=?, post_title=?,"
					+ "post_content=?,post_writedate=sysdate,post_location=?,post_payment=?,post_phone=? where post_id = ?";
			stmt = conn.prepareStatement(statement);
			stmt.setString(1, vo.getMem_userid());
			stmt.setString(2, vo.getMem_username());
			stmt.setString(3, vo.getPost_title());
			stmt.setString(4, vo.getPost_content());
			stmt.setString(5, vo.getPost_location());
			stmt.setInt(6, vo.getPost_payment());
			stmt.setString(7, vo.getPost_phone());
			stmt.setInt(8, vo.getPost_id());
			int result = stmt.executeUpdate();
			if(result == 1) {
				flag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn, stmt, null);
		}
		return flag;
	}
	public int delete(int post_id) {
		int num = 0;
		PreparedStatement stmt = null;
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement("delete from jobad where post_id = " + post_id);
			num = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,null);
		}
		return num;
	}
	public int getCount() {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from jobad");
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return totalCount;
	}
	public int getCount(String mem_username) {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from jobad where mem_username = '"+mem_username+"'");
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return totalCount;
	}
	public int getCount(String key,String searchType) {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnection();
		String searchExpr;
		try {
			stmt = conn.createStatement();
			if(searchType.equals("content")) {
				searchExpr = " content like '%"+key+"%'";
			}
			else if(searchType.equals("title")) {
				searchExpr = " title like '%"+key+"%'";
			}
			else {
				searchExpr = " title like '%"+key+"%'"+" or content like '%"+key+"%'";
			}
			rs = stmt.executeQuery("select count(*) from jobad where "+searchExpr);
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return totalCount;
	}
	public String getPageLinkList(int curPage,String linkStr, int size) {
		PagingControl page = new PagingControl(10,5,size,curPage);
		StringBuilder buffer = new StringBuilder();
		if(page.isPreData()) {
			buffer.append("<a href='/mvc/jobad?pgNum=");
			buffer.append((page.getPageStart()-1)+linkStr+"'>");
			buffer.append("<img src='/mvc/images/left.png' width='15'></a> ");
		}
		for(int i = page.getPageStart(); i <= page.getPageEnd();i++) {
			if(i == curPage) {
				buffer.append("<a href='/mvc/jobad?pgNum="+i+linkStr+"'"+" style='font-weight:bold;'>"+i+"</a> ");
			}
			else {
				buffer.append("<a href='/mvc/jobad?pgNum="+i+linkStr+"'"+">"+i+"</a> ");
			}
		}
		if(page.isNextData()) {
			buffer.append("<a href='/mvc/jobad?pgNum=");
			buffer.append((page.getPageEnd()+1)+linkStr+"'>");
			buffer.append(" <img src='/mvc/images/right.png' width='15'></a>");
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	public List<JobadVO> listAll(int curPage){
		Statement stmt = null;
		ResultSet rs = null;
		List<JobadVO> list = new ArrayList<>();
		Connection conn = getConnection();
		try {
			stmt = conn.createStatement();
			PagingControl page = new PagingControl(10,5,getCount(),curPage);
			System.out.println(page.getWritingStart()+", "+page.getWritingEnd());
			String sql = "select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment,post_phone,post_review_count from "
					+"(select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment"
					+ ",post_phone,post_review_count,rownum rnum from "
					+ "(select post_id,mem_userid,mem_username,post_title,post_content,to_char(post_writedate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\":mi\"분\"') post_writedate,post_hit,post_location,post_payment "
					+ ",post_phone,post_review_count from jobad order by post_writedate desc)) "
					+ "where rnum between "+page.getWritingStart()+" and "
					+page.getWritingEnd();
			rs = stmt.executeQuery(sql);
			list = makeList(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return list;
	}
	public List<JobadVO> listWriter(String mem_username,int curPage){
		Statement stmt = null;
		ResultSet rs = null;
		List<JobadVO> list = null;
		Connection conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from jobad where mem_username = '"+mem_username+"'");
			rs.next();
			int count = rs.getInt(1);
			PagingControl page = new PagingControl(10,5,count,curPage);
			String sql = "select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment,post_phone,post_review_count from "
					+"(select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment"
					+ ",post_phone,post_review_count,rownum rnum from "
					+ "(select post_id,mem_userid,mem_username,post_title,post_content,to_char(post_writedate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\":mi\"분\"') post_writedate,post_hit,post_location,post_payment "
					+ ",post_phone,post_review_count from jobad where mem_username='"+mem_username+"'order by post_writedate desc)) "
					+ "where rnum between "+page.getWritingStart()+" and "
					+page.getWritingEnd();
			rs = stmt.executeQuery(sql);
			list = makeList(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	public List<JobadVO> listSort(String sortColumn, int curPage){
		Statement stmt = null;
		ResultSet rs = null;
		List<JobadVO> list = null;
		Connection conn = getConnection();
		try {
			PagingControl page = new PagingControl(10,5,getCount(),curPage);
			String sql = "select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment,post_phone,post_review_count from "
					+ "(select post_id,mem_userid,mem_username,post_title,post_content,post_writedate,post_hit,post_location,post_payment,post_phone,post_review_count,rownum rnum from "
					+ "(select post_id,mem_userid,mem_username,post_title,post_content,to_char(post_writedate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\":mi\"분\"') post_writedate,post_hit,post_location,post_payment,post_phone,post_review_count from "
					+ "jobad order by "+sortColumn+" asc)) "
					+ "where rnum between "+page.getWritingStart()+" and "+page.getWritingEnd();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = makeList(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return list;
	}
	
	public List<JobadVO> search(String key,String searchType,int curPage){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		List<JobadVO> list = null;
		String searchExpr = "";
		if(searchType.equals("content")) {
			searchExpr = " post_content like '%"+key+"%'";
		}
		else if(searchType.equals("title")) {
			searchExpr = " post_title like '%"+key+"%'";
		}
		else {
			searchExpr = " post_title like '%"+key+"%'"+" OR post_content like '%"+key+"%'";
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from Jobad where "+searchExpr);
			rs.next();
			int count = rs.getInt(1);
			if(count>0) {
				PagingControl page = new PagingControl(10,5,count,curPage);
				String sql = "select post_id,mem_userid,mem_username,post_title,"
						+ "post_content,post_writedate,post_hit,post_location,"
						+ "post_payment,post_phone,post_review_count "
						+ "from ("
						+ "select post_id,mem_userid,mem_username,post_title,"
						+ "post_content,to_char(post_writedate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\":mi\"분\"') post_writedate,post_hit,post_location,"
						+ "post_payment,post_phone,post_review_count,rownum rnum from jobad where "
						+ searchExpr
						+ ") where rnum between "+page.getWritingStart()
						+" and "+page.getWritingEnd();
				rs = stmt.executeQuery(sql);
				list = makeList(rs);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return list;
	}
	
	public JobadVO listOne(int post_id) {
		Statement stmt = null;
		ResultSet rs = null;
		JobadVO vo = new JobadVO();
		Connection conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery
				("select post_id,mem_userid,mem_username,post_title,post_content,"
				+ "to_char(post_writedate,'yyyy\"년\" mm\"월\" dd\"일\" hh24\"시\":mi\"분\"') post_writedate,post_hit,post_location,post_payment,"
				+ "post_phone,post_review_count from jobad "
				+ "where post_id="+post_id);
			if(rs.next()) {
				vo.setPost_id(rs.getInt(1));
				vo.setMem_userid(rs.getString(2));
				vo.setMem_username(rs.getString(3));
				vo.setPost_title(rs.getString(4));
				vo.setPost_content(rs.getString(5));
				vo.setPost_writedate(rs.getString(6));
				vo.setPost_hit(rs.getInt(7));
				vo.setPost_location(rs.getString(8));
				vo.setPost_payment(rs.getInt(9));
				vo.setPost_phone(rs.getString(10));
				vo.setPost_review_count(rs.getInt(11));
			}
			stmt.executeQuery("update jobad set post_hit=post_hit+1 where post_id="+post_id);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,rs);
		}
		return vo;
	}
	
	private List<JobadVO> makeList(ResultSet rs) throws SQLException {
		ArrayList<JobadVO> list = null;
		if (rs.next()) {
			list = new ArrayList<JobadVO>();
			do {
				JobadVO vo = new JobadVO();
				vo.setPost_id(rs.getInt(1));
				vo.setMem_userid(rs.getString(2));
				vo.setMem_username(rs.getString(3));
				vo.setPost_title(rs.getString(4));
				vo.setPost_content(rs.getString(5));
				vo.setPost_writedate(rs.getString(6));
				vo.setPost_hit(rs.getInt(7));
				vo.setPost_location(rs.getString(8));
				vo.setPost_payment(rs.getInt(9));
				vo.setPost_phone(rs.getString(10));
				vo.setPost_review_count(rs.getInt(11));
				list.add(vo);
			} while (rs.next());
		}
		return list;
	}
}
