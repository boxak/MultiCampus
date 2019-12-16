package day10;

public class PolyTest {

	public static void main(String[] args) {
		
		//printObjectInfo(); argument�� ���� �ʾұ� ������ ����
		printObjectInfo(new Object()); //���⿡�� �ٷ� �����ص� ������ ����. �ٸ� �ѹ��ۿ� �����Ѵ�.
		printObjectInfo(new String("������"));
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
			System.out.println("���ڿ� ��ü ���޵� : "+o.getClass().getName()+"-"+((String)o).length());
		}
		else {
			System.out.println("���޵� ��ü�� Ŭ������ : "+o.getClass().getName()); //Ŭ������ ����
		}
	}

}
