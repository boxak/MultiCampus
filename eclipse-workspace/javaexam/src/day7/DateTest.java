package day7;
import java.util.Date; //�ٸ� ��Ű���� �ִ� �޼��� ȣ���ϴ� ��
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		//Date
		Date d=new Date();
		System.out.println(d.toString()); //���� �ð����� �������� ���缭 ������Ű�� �ٶ��ϴ�.
		GregorianCalendar gc=new GregorianCalendar(); //��ü�� �����Ǵ� ������ �ð��� ��ϵ�.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc=new GregorianCalendar(2019, 11, 25); //1���� 0���� ������ -> 12���̸� 11�� �ִ´�.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc=new GregorianCalendar(1995, 1, 4); 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
	}

}
