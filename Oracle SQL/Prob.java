package jdbcsrc;


import java.sql.*;

public class Prob {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		kaja("E");
		

	}
	
	public static void kaja(String fn) {
		String sql="select first_name,last_name,to_char(salary,'999,900') as salary"
				+ " from employees"
				+ " where first_name like '%"+fn+"%'";
		try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);){
			
			if(rs.next()) {
				do {
					System.out.println(rs.getString("first_name")+"("+
					rs.getString("last_name")+")"+rs.getString("salary")+"원");
				}while(rs.next());
			}
			else {
				System.out.println("아무것도 출력되지 않음");
			}
			
		}catch(Exception e) {
			System.out.println("오류 발생 : "+ e);
		}
	}
	

}
