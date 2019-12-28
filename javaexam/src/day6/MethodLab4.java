package day6;

public class MethodLab4 {

	public static void main(String[] args) {
		int Array1[]=new int[] {10,20,30};
		int Array2[]=new int[] {100,500,300,200,400};
		int Array3[]=new int[] {1,10,3,4,5,8,7,6,9,2};
		int twoArray[][]= new int[][]{Array1,Array2,Array3};
		for(int i=0;i<twoArray.length;i++) {
			System.out.printf("가장 큰 값은 %d 입니다%n",maxNumArray(twoArray[i]));
		}
		System.out.println();
	}
	
	static int maxNumArray(int p[]) {
		int maxNum=-10000;
		for(int data : p) {
			if(data>maxNum) {
				maxNum=data;
			}
		}
		return maxNum;
	}

}
