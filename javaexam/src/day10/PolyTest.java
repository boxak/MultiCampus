package day10;

public class PolyTest {

	public static void main(String[] args) {
		
		//printObjectInfo(); argument를 주지 않았기 때문에 에러
		printObjectInfo(new Object()); //여기에서 바로 생성해도 문제는 없다. 다만 한번밖에 사용못한다.
		printObjectInfo(new String("가나다"));
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:/Temp"));
		printObjectInfo(new java.io.File("c:/Jiwon-Hwang/javaexam"));
		printObjectInfo(new int[10]);
		printObjectInfo(new double[5]);
		printObjectInfo(new day7.Member());
		printObjectInfo(new Integer(100));
		Object obj=new String("aaa");
		
	}
	
	static void printObjectInfo(Object o) {
		if(o instanceof String) {
			System.out.println("문자열 객체 전달됨 : "+o.getClass().getName()+"-"+((String)o).length());
		}
		else {
			System.out.println("전달된 객체의 클래스명 : "+o.getClass().getName()); //클래스를 리턴
		}
	}

}
