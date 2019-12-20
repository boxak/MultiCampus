package day4;

public class ArrayLab2 {

	public static void main(String[] args) {
		int Arr[]=new int[10];
		int sum=0;
		for(int i=0;i<10;i++) {
			Arr[i]=(int)(Math.random()*17)+4;
			sum+=Arr[i];
		}
		System.out.print("모든 원소의 값 : ");
		for(int i=0;i<9;i++) {
			System.out.printf("%d,",Arr[i]);
		}
		System.out.println(Arr[9]);
		System.out.println("모든 원소의 합 : "+sum);
	}

}
