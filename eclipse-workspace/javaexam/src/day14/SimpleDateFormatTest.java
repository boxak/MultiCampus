package day14;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static String timeToStrDate(long time) {
		DateFormat formatter = 
				new SimpleDateFormat("yyyy-MM-dd"); //�빮�� : Month �ҹ��� : minute
		return formatter.format(time);
	}

	public static Date parseStrDate(String strDate) throws ParseException {
		DateFormat formatter = 
				new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		return formatter.parse(strDate);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2019�� 12�� 25�� 4�� 36�� 36��")); //������ �о�鼭 �ľ��Ѵ� -> �Ľ��Ѵ�. 		
	}
}


