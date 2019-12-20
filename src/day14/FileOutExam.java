package day14;
import java.io.*;
import java.util.GregorianCalendar;
public class FileOutExam {

	public static void main(String[] args) {
		try (FileWriter  writer = new FileWriter("c:/iotest/today.txt");){
			char c1[]= {'오','늘','은',' '};
			GregorianCalendar cal=new GregorianCalendar();
			String todayYear=Integer.toString(cal.get(GregorianCalendar.YEAR));
			String todayMonth=Integer.toString(cal.get(GregorianCalendar.MONTH)+1);
			String todayDay=Integer.toString(cal.get(GregorianCalendar.DATE));
			char c2[]= {'년',' ','월',' ','일','입','니','다','.'};
			int whatDay=cal.get(GregorianCalendar.DAY_OF_WEEK)-1;
			char days[]= {'일','월','화','수','목','금','토'};
			char myName[]= {'황','지','원'};
			GregorianCalendar myBirth=new GregorianCalendar(1995,2,4);
			int myBirthDay=myBirth.get(GregorianCalendar.DAY_OF_WEEK)-1;
			char c3[]= {'요','일','에',' ','태','어','났','습','니','다','.'};
			
			for(int i=0;i<c1.length;i++) {
				writer.write(c1[i]);
			}
			for(int i=0;i<todayYear.length();i++) {
				writer.write(todayYear.charAt(i));
			}
			for(int i=0;i<=1;i++) {
				writer.write(c2[i]);
			}
			for(int i=0;i<todayMonth.length();i++) {
				writer.write(todayMonth.charAt(i));
			}
			for(int i=2;i<=3;i++) {
				writer.write(c2[i]);
			}
			for(int i=0;i<todayDay.length();i++) {
				writer.write(todayDay.charAt(i));
			}
			writer.write('일');
			for(int i=5;i<=8;i++) {
				writer.write(c2[i]);
			}
			writer.write("\r\n");
			for(int i=0;i<c1.length;i++) {
				writer.write(c1[i]);
			}
			writer.write(days[whatDay]);
			writer.write('요');
			writer.write('일');
			for(int i=5;i<=8;i++) {
				writer.write(c2[i]);
			}
			writer.write("\r\n");
			for(int i=0;i<3;i++) {
				writer.write(myName[i]);
			}
			writer.write('은');
			writer.write(' ');
			writer.write(days[myBirthDay]);
			for(int i=0;i<c3.length;i++) {
				writer.write(c3[i]);
			}
			System.out.println("저장이 완료되었습니다.");
		}catch(IOException ioe) {
			System.out.println("파일을 저장하는 동안 오류가 발생했습니다.");
		}
		
	}

}
