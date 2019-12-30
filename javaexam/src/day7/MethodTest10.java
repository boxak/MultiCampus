package day7;

public class MethodTest10 {

	public static void main(String[] args) {
		int p1[]= {20,10,14,30};
		System.out.println("p1의 값 : "+p1);
		printArray(p1);
		int[] result=updateArray1(p1); //p1이 가진 참조값을 P2애개 준다.!
		printArray(result);
		printArray(p1); //p1은 변경되지 않았다.
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
	
	
	static int [] updateArray1(int[] p2) { //가변형 인자는 아님! 
		System.out.println("p2 변수의 값 : "+p2);
		int[] result=new int[p2.length];
		for(int i=0;i<p2.length;i++) {
			result[i]=2*p2[i];
		}
		return result; //배열의 참조값을 리턴
	}
	
	static void updateArray2(int[] p3) {
		System.out.println("p3 변수의 값 : "+p3);
		for(int i=0;i<p3.length;i++) {
			p3[i]=p3[i]*2;
		}
	}
	
}
