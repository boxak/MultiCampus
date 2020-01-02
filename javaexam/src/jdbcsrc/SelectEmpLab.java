package jdbcsrc;

import java.sql.*;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		
		try {
			//����Ŭ Ŭ���� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			//Ŭ������ ã�� ������ ���.
			System.out.println("���� �߻� : "+cnfe);
		}
		String address="jdbc:oracle:thin:@localhost:1521:XE";
		String sql=null;
		
		//true �� �̸�, ���� 
		//false�� �̸�, �Ի糯¥�� sql�� ��´�.
		boolean flag=new Random().nextBoolean();
		
		if(flag) {
			sql="select ename||' '||'������ ','������ '||to_char(sal,'999,999')||'�� �Դϴ�.' as sal from emp";
		}
		else {
			sql="select ename||' '||'������ ',to_char(hiredate,'yyyy\"��\" fmmm\"��\" dd\"��\"')||'�� �Ի��Ͽ����ϴ�.' as hiredate from emp";
		}
		
		try(Connection conn=DriverManager.getConnection(address,"scott","tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);){
			if(rs.next()) {
				//rs�� �� ���̺��� �ƴϸ�
				do {
					//emp�� �̸�, ���� �Ǵ� �̸�, �Ի糯¥�� ���
					System.out.print(rs.getString(1));
					System.out.print(rs.getString(2)+"\n");
				}while(rs.next());
			}
			else {
				//rs�� �� ���̺��̸�
				System.out.println("�ƹ��͵� ��µ��� �ʾƿ�.");
			}
		}catch(Exception e) {
			System.out.println("���� �߻� : "+e);
		}

	}

}
