package javaexam;

public class exercise2 {

	public static void main(String[] args) {
		
		int Arr[]=new int [] {3,2,1,6,5,4};
		printArr(Arr);
		sortArr(Arr);
		printArr(Arr);
		System.out.println("sum="+sumArr(Arr));
	}
	
	static void printArr(int[] Arr) {
		System.out.print("[");
		for(int i : Arr) {
			System.out.printf("%d ", i);
		}
		System.out.println("]");
	}
	
	static int sumArr(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	static void sortArr(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min=arr[i];
			int minInx=i;
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min=arr[j];
					minInx=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[minInx];
			arr[minInx]=temp;
		}
	}
	

}
