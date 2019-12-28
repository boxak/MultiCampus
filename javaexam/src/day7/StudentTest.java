package day7;

class Student{ //생성자가 없는 클래스, 구현하지 않았으면 만들어서 넣어줌.->무조건 argument를 안받음
	String name;
	int age;
	String subject;
	//static이 없어도 된다. student 에 없기 때문.
	
	void printInfo() {
		System.out.println(name+"학생은 나이가"+age+"입니다.");
	}
	void study() {
		System.out.println(name+"학생은 "+subject+"과목을 학습합니다.");
	}
}

public class StudentTest {

	public static void main(String[] args) {
		Student st1=new Student(); //->객채 생성
		System.out.println(st1);
		System.out.println(st1.name);
		System.out.println(st1.age);
		System.out.println(st1.subject);
		st1.printInfo(); //참조형 변수의 기본값 : null
		st1.study();
		st1.name="듀크";
		st1.age=24;
		st1.subject="HTML5";
		st1.printInfo();
		st1.study();
		Student st2=new Student();
		System.out.println(st2);
		System.out.println(st2.name);
		System.out.println(st2.age);
		System.out.println(st2.subject);
		st2.printInfo(); //참조형 변수의 기본값 : null
		st2.study();
		st2.name="턱시";
		st2.age=24;
		st2.subject="HTML5";
		st2.printInfo();
		st2.study();
		//st1 과 st2가 참조하는 값이 다르다.
		System.out.println("st2=st1 수행"); //st2가 참조하던 객체는 가비지가 됌.
		st2=st1;
		System.out.println(st1);
		System.out.println(st2);
		st1.printInfo();
		st1.study();
		st2.printInfo();
		st2.study();
		//둘다 듀크의 정보를 참조함
	}

}
