package day7;

class StudentNew{
	String name;
	int age;
	String subject;
	//static�� ��� �ȴ�. student �� ���� ����.
	
	StudentNew(String p1,int p2,String p3){ //�տ� void �� ���̸� �ȵȴ�
		name=p1;
		age=p2;
		subject=p3;
	}
	
	void printStudentInfo() {
		System.out.println(name+"�л��� ���̰�"+age+"�Դϴ�.");
	}
	void study() {
		System.out.println(name+"�л��� ������"+subject+"������ �н��մϴ�.");
	}
	void study(int hour) {
		System.out.println(name+"�л��� "+subject+"������ "+hour+"�ð� ���� ������ �н��մϴ�.");
	}
}

public class StudentTest2 {

	public static void main(String[] args) {
		StudentNew st1=new StudentNew("Jane",24,"JavaScript"); //->��ä ����
		System.out.println(st1);
		st1.study(2); //�ٷ� �޼��带 ȣ���ϸ� null�л�, null�������� ��µȴ�.
		StudentNew st2=new StudentNew("�Ѹ�",100,"Scalar");
		System.out.println(st2);
		st2.study(2);
	}

}
