package day7;

public class MethodTest10 {

	public static void main(String[] args) {
		int p1[]= {20,10,14,30};
		System.out.println("p1�� �� : "+p1);
		printArray(p1);
		int[] result=updateArray1(p1); //p1�� ���� �������� P2�ְ� �ش�.!
		printArray(result);
		printArray(p1); //p1�� ������� �ʾҴ�.
		System.out.println("-----------------");
		updateArray2(p1);
		printArray(p1);
	}
	
	static void printArray(int[] p2) {
		for(int data : p2) {
			System.out.printf("%d ",data);
		}
		System.out.printf("%n");
	}
	
	
	static int [] updateArray1(int[] p2) { //������ ���ڴ� �ƴ�! 
		System.out.println("p2 ������ �� : "+p2);
		int[] result=new int[p2.length];
		for(int i=0;i<p2.length;i++) {
			result[i]=2*p2[i];
		}
		return result; //�迭�� �������� ����
	}
	
	static void updateArray2(int[] p3) {
		System.out.println("p3 ������ �� : "+p3);
		for(int i=0;i<p3.length;i++) {
			p3[i]=p3[i]*2;
		}
	}
	
}
