package my.spring.springnews;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbctest {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","javas","1234");
			System.out.println("Success!");
		}
		catch(Exception e){
			System.out.println("Fail!");
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}