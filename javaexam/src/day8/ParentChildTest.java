package day8;

class Parent{ //아무것도 없는 것같지만 java.lang.Object 라는 클래스를 상속받는다. 
	int x=1,y=2;
	public String toString() {
		return "Parent 클래스의 객체입니당";
	}
	
}

class Child extends Parent{
	int x=10;
	void printInfo() {
		int x=100; //멤버 변수와 지역 변수 이름이 같으면 지역 변수를 사용.
		System.out.println(x); 
		System.out.println(this.x); 
		System.out.println(super.x);
		System.out.println(y);
		System.out.println(this.y);
		System.out.println(super.y);
		//System.out.println(z);
	}
	public String toString() {
		return "Child 클래스의 객체입니당";
	}
}

public class ParentChildTest {

	public static void main(String[] args) {
		Parent p=new Parent(); // 디폴트 생성자
		System.out.println(p.toString()); //객체의 정보를 하나의 문자열로 리턴하는 메서드
		System.out.println(p);
		System.out.println("출력1 "+p);
		Card c=new Card();
		System.out.println(c.toString());
		System.out.println("출력2 "+c);
		java.util.Date d=new java.util.Date();
		System.out.println(d.toString()); //메서드 오버라이딩
		System.out.println("출력3 "+d);
		Child ch=new Child();
		System.out.println("출력4 "+ch);
		ch.printInfo();
		System.out.println(ch.x);
		System.out.println(ch.y);
	}

}
