package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			conn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	private void close(Connection conn,Statement stmt,ResultSet rs) {
		try {
			conn.close();
			stmt.close();
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean insert(NewsVO vo) {
		System.out.println("insert");
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			pstmt = conn.prepareStatement
				("insert into news values(news_seq.nextval,?,?,?,sysdate,0)");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		try {
			close(conn,pstmt,null);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public boolean update(NewsVO vo) {
		System.out.println("update");
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			pstmt = conn.prepareStatement
				("update news set writer=?,"
						+ " title=?,"
						+ " content=?,"
						+ " writedate="
						+ "sysdate,"
						+ " cnt=?"
						+ " where id=?");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt());
			pstmt.setInt(5, vo.getId());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		try {
			close(conn,pstmt,null);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public boolean delete(int id) {
		System.out.println("delete");
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			pstmt = conn.prepareStatement
				("delete from news where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		try {
			close(conn,pstmt,null);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return flag;
		
	}
	public List<NewsVO> listAll(){
		System.out.println("listAll");
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery
				("select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
						+ " from news");
			NewsVO vo = null;
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			close(conn,stmt,rs);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public NewsVO listOne(int id) {
		System.out.println("listOne");
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		NewsVO vo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery
				("select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
						+ " from news where id="+id);
			if(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6)+1);
				update(vo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			close(conn,stmt,rs);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	public List<NewsVO> listWriter(String Writer){
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery
				("select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
				+" from news where writer like '%"+Writer+"%'");
			NewsVO vo = null;
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<NewsVO> search(String key,String searchType){
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = new ArrayList<>();
		String[] strArr = searchType.split("and");
		//System.out.println(strArr[0]);
		String query = "";
		if(strArr.length==1) {
			query = "select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
				+ " from news where "
				+ strArr[0]+" like "+"'%"+key+"%'";
		}
		else if(strArr.length==2) {
			query = "select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
					+ " from news where "
					+ strArr[0]+" like "+"'%"+key+"%'"
					+" or "+strArr[1]+" like "+"'%"+key+"%'";
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			NewsVO vo = null;
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
