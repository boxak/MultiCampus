package day7;

class StudentNew2{
	String name;
	int age;
	String subject;
	//static�� ��� �ȴ�. student �� ���� ����.
	
	StudentNew2(){
		
	}
	
	StudentNew2(String p1,int p2){
		name=p1;
		age=p2;
		subject="Java";
	}
	
	StudentNew2(String p1,int p2,String p3){ //�տ� void �� ���̸� �ȵȴ�
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

public class StudentTest3 {

	public static void main(String[] args) {
		StudentNew2 st1=new StudentNew2("Jane",24,"JavaScript"); //->��ä ����
		System.out.println(st1);
		st1.study(2); //�ٷ� �޼��带 ȣ���ϸ� null�л�, null�������� ��µȴ�.
		StudentNew2 st2=new StudentNew2("�Ѹ�",100);
		System.out.println(st2);
		st2.study(2);
		StudentNew2 st3=new StudentNew2(); //��� ������ ���� �� �ʱⰪ���� ���´�.
		System.out.println(st3);
		st3.study(2);
	}

}
