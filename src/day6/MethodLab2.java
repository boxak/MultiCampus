package day6;

public class MethodLab2 {

	public static void main(String[] args) {
		int a1=(int)(Math.random()*30)+1;
		int a2=(int)(Math.random()*30)+1;
		System.out.println(a1+"�� "+a2+"�� ���� "+getDiff(a1,a2)+"�Դϴ�.");
	}
	static int getDiff(int a1,int a2) {
		//int result=�� ����ؼ� return �� ������ �ּ�ȭ�� �� �ִ�.
		if(a1==a2) {
			return 0;
		}
		else if(a1>a2) {
			return a1-a2;
		}
		else {
			return a2-a1;
		}
	}
}
