package day14;
import java.io.*;
import java.util.GregorianCalendar;
public class FileOutExam {

	public static void main(String[] args) {
		try (FileWriter  writer = new FileWriter("c:/iotest/today.txt");){
			char c1[]= {'��','��','��',' '};
			GregorianCalendar cal=new GregorianCalendar();
			String todayYear=Integer.toString(cal.get(GregorianCalendar.YEAR));
			String todayMonth=Integer.toString(cal.get(GregorianCalendar.MONTH)+1);
			String todayDay=Integer.toString(cal.get(GregorianCalendar.DATE));
			char c2[]= {'��',' ','��',' ','��','��','��','��','.'};
			int whatDay=cal.get(GregorianCalendar.DAY_OF_WEEK)-1;
			char days[]= {'��','��','ȭ','��','��','��','��'};
			char myName[]= {'Ȳ','��','��'};
			GregorianCalendar myBirth=new GregorianCalendar(1995,2,4);
			int myBirthDay=myBirth.get(GregorianCalendar.DAY_OF_WEEK)-1;
			char c3[]= {'��','��','��',' ','��','��','��','��','��','��','.'};
			
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
			writer.write('��');
			for(int i=5;i<=8;i++) {
				writer.write(c2[i]);
			}
			writer.write("\r\n");
			for(int i=0;i<c1.length;i++) {
				writer.write(c1[i]);
			}
			writer.write(days[whatDay]);
			writer.write('��');
			writer.write('��');
			for(int i=5;i<=8;i++) {
				writer.write(c2[i]);
			}
			writer.write("\r\n");
			for(int i=0;i<3;i++) {
				writer.write(myName[i]);
			}
			writer.write('��');
			writer.write(' ');
			writer.write(days[myBirthDay]);
			for(int i=0;i<c3.length;i++) {
				writer.write(c3[i]);
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}catch(IOException ioe) {
			System.out.println("������ �����ϴ� ���� ������ �߻��߽��ϴ�.");
		}
		
	}

}
