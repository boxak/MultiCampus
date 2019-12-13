package day9;

class A{
	A(){
		System.out.println("A 클래스를 객체 생성합니다.");
	}
}

class B extends A{
	int num;
	/*
	B(){
		System.out.println("B 클래스를 객체 생성합니다.");
	}*/
	B(int p){
		num=p;
		System.out.println("B 클래스의 객체 생성합니다.");
	}
}

class C extends B{
	C(){
		super(100);
		System.out.println("C 클래스를 객체 생성합니다.");
	}
}

public class ABCTest {

	public static void main(String[] args) {
		new C(); //객체 생성만 해도 된다.
		
	}

}
