package day7;
import java.util.Date; //다른 패키지에 있는 메서드 호출하는 법
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		//Date
		Date d=new Date();
		System.out.println(d.toString()); //현재 시간법을 영문법에 맞춰서 수리시키기 바랍니다.
		GregorianCalendar gc=new GregorianCalendar(); //객체가 생성되는 시점의 시각이 기록됨.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc=new GregorianCalendar(2019, 11, 25); //1월을 0으로 시작함 -> 12월이면 11을 넣는다.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc=new GregorianCalendar(1995, 1, 4); 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
	}

}
