package day8;

class Parent{ //�ƹ��͵� ���� �Ͱ����� java.lang.Object ��� Ŭ������ ��ӹ޴´�. 
	int x=1,y=2;
	public String toString() {
		return "Parent Ŭ������ ��ü�Դϴ�";
	}
	
}

class Child extends Parent{
	int x=10;
	void printInfo() {
		int x=100; //��� ������ ���� ���� �̸��� ������ ���� ������ ���.
		System.out.println(x); 
		System.out.println(this.x); 
		System.out.println(super.x);
		System.out.println(y);
		System.out.println(this.y);
		System.out.println(super.y);
		//System.out.println(z);
	}
	public String toString() {
		return "Child Ŭ������ ��ü�Դϴ�";
	}
}

public class ParentChildTest {

	public static void main(String[] args) {
		Parent p=new Parent(); // ����Ʈ ������
		System.out.println(p.toString()); //��ü�� ������ �ϳ��� ���ڿ��� �����ϴ� �޼���
		System.out.println(p);
		System.out.println("���1 "+p);
		Card c=new Card();
		System.out.println(c.toString());
		System.out.println("���2 "+c);
		java.util.Date d=new java.util.Date();
		System.out.println(d.toString()); //�޼��� �������̵�
		System.out.println("���3 "+d);
		Child ch=new Child();
		System.out.println("���4 "+ch);
		ch.printInfo();
		System.out.println(ch.x);
		System.out.println(ch.y);
	}

}
