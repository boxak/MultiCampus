package day7;

class StudentNew{
	String name;
	int age;
	String subject;
	//static이 없어도 된다. student 에 없기 때문.
	
	StudentNew(String p1,int p2,String p3){ //앞에 void 도 붙이면 안된다
		name=p1;
		age=p2;
		subject=p3;
	}
	
	void printStudentInfo() {
		System.out.println(name+"학생은 나이가"+age+"입니다.");
	}
	void study() {
		System.out.println(name+"학생은 과목이"+subject+"과목을 학습합니다.");
	}
	void study(int hour) {
		System.out.println(name+"학생은 "+subject+"과목을 "+hour+"시간 동안 과목을 학습합니다.");
	}
}

public class StudentTest2 {

	public static void main(String[] args) {
		StudentNew st1=new StudentNew("Jane",24,"JavaScript"); //->객채 생성
		System.out.println(st1);
		st1.study(2); //바로 메서드를 호출하면 null학생, null과목으로 출력된다.
		StudentNew st2=new StudentNew("둘리",100,"Scalar");
		System.out.println(st2);
		st2.study(2);
	}

}
