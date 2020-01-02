package jdbcsrc;

import java.sql.*;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		
		try {
			//오라클 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			//클래스를 찾지 못했을 경우.
			System.out.println("오류 발생 : "+cnfe);
		}
		String address="jdbc:oracle:thin:@localhost:1521:XE";
		String sql=null;
		
		//true 면 이름, 월급 
		//false면 이름, 입사날짜를 sql에 담는다.
		boolean flag=new Random().nextBoolean();
		
		if(flag) {
			sql="select ename||' '||'직원의 ','월급은 '||to_char(sal,'999,999')||'원 입니다.' as sal from emp";
		}
		else {
			sql="select ename||' '||'직원은 ',to_char(hiredate,'yyyy\"년\" fmmm\"월\" dd\"일\"')||'에 입사하였습니다.' as hiredate from emp";
		}
		
		try(Connection conn=DriverManager.getConnection(address,"scott","tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);){
			if(rs.next()) {
				//rs가 빈 테이블이 아니면
				do {
					//emp의 이름, 월급 또는 이름, 입사날짜를 출력
					System.out.print(rs.getString(1));
					System.out.print(rs.getString(2)+"\n");
				}while(rs.next());
			}
			else {
				//rs가 빈 테이블이면
				System.out.println("아무것도 출력되지 않아요.");
			}
		}catch(Exception e) {
			System.out.println("오류 발생 : "+e);
		}

	}

}
