package day6;

public class MethodLab5 {

	public static void main(String[] args) {
		int r1[]=powerArray(2);
		int r2[]=powerArray(3);
		int r3[]=powerArray(4);
		int twoArr[][]=new int[][] {r1,r2,r3};
		for(int i=0;i<twoArr.length;i++) {
			for(int j=0;j<twoArr[0].length;j++) {
				System.out.printf(j<twoArr[0].length-1 ? "%d," : "%d%n",twoArr[i][j]);
			}
		}
	}
	static int[] powerArray(int n) {
		int naturalNum[]=new int[] {1,2,3,4,5,6,7,8,9,10};
		int resultArr[]=new int[10];
		for(int i=0;i<naturalNum.length;i++) {
			resultArr[i]=n*naturalNum[i];
		}
		return resultArr;
	}
}
