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
		Connection conn = connectDB();
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			//System.out.println("1");
			pstmt = conn.prepareStatement
				("insert into news values(news_seq.nextval,?,?,?,sysdate,0)");
			//System.out.println("2");
			pstmt.setString(1, vo.getWriter());
			//System.out.println("3");
			pstmt.setString(2, vo.getTitle());
			//System.out.println("4");
			pstmt.setString(3, vo.getContent());
			//System.out.println("5");
			pstmt.executeUpdate();
			//System.out.println("6");
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
						+ " cnt=? "
						+ "where id=?");
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
		Connection conn = connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = new ArrayList<>();
		try {
			//System.out.println("1/1");
			stmt = conn.createStatement();
			rs = stmt.executeQuery
				("select id,writer,title,content,to_char(writedate,'yyyy-mm-dd hh24:mi'),cnt"
						+ " from news");
			//System.out.println("1/2");
			NewsVO vo = null;
			while(rs.next()) {
				//System.out.println("1/3");
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				//System.out.println("1/4");
				vo.setWriter(rs.getString(2));
				//System.out.println("1/5");
				vo.setTitle(rs.getString(3));
				//System.out.println("1/6");
				vo.setContent(rs.getString(4));
				//System.out.println("1/7");
				vo.setWritedate(rs.getString(5));
				//System.out.println("1/8");
				vo.setCnt(rs.getInt(6));
				//System.out.println("1/9");
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
				System.out.println("id : "+vo.getId());
				System.out.println("writer : "+vo.getWriter());
				System.out.println("title : "+vo.getTitle());
				System.out.println("content : "+vo.getContent());
				System.out.println("writedate : "+vo.getWritedate());
				System.out.println("cnt : "+vo.getCnt());
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
}
