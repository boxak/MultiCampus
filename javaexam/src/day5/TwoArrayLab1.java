package day5;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		int Array1[][]=new int [4][4];
		int num=10;
		for(int i=0;i<Array1.length;i++) {
			for(int j=0;j<Array1[i].length;j++) {
				Array1[i][j]=num;
				num+=2;
			}
		}
		System.out.println("1행 1열의 데이터 : "+Array1[0][0]);
		System.out.println("3행 4열의 데이터 : "+Array1[2][3]);
		System.out.println("행의 갯수 : "+Array1.length);
		System.out.println("열의 갯수 : "+Array1[0].length);
		System.out.print("3행의 데이터들 : ");
		for(int col=0;col<Array1[2].length;col++) {
			System.out.print(Array1[2][col]+" ");
		}
		System.out.println();
		System.out.print("2열의 데이터들 : ");
		for(int row=0;row<Array1.length;row++) {
			System.out.print(Array1[row][1]+" ");
		}
		System.out.println();
		System.out.print("왼쪽 대각선 데이터들 : ");
		for(int i=0;i<Array1.length;i++) {
			System.out.print(Array1[i][i]+" ");
		}
		System.out.println();
		System.out.print("오른쪽 대각선 데이터들 : ");
		for(int i=0;i<Array1.length;i++) {
			System.out.print(Array1[i][Array1.length-1-i]+" ");
		}
	}

}
