package day5;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		char Array2[][]= {
				{'B','C','A','A'},
				{'C','C','B','B'},
				{'D','A','A','D'}
		};
		for(int row=0;row<Array2.length;row++) {
			for(int col=0;col<Array2[0].length-1;col++) {
				System.out.print(Array2[row][col]+", ");
			}
			System.out.println(Array2[row][Array2[0].length-1]);
		}
		int cnt[]=new int [4];
		for(int i=0;i<cnt.length;i++) cnt[i]=0;
		for(int i=0;i<Array2.length;i++) {
			for(int j=0;j<Array2[0].length;j++) {
				if(Array2[i][j]=='A') cnt[0]++;
				else if(Array2[i][j]=='B') cnt[1]++;
				else if(Array2[i][j]=='C') cnt[2]++;
				else cnt[3]++;
			}
		}
		System.out.println("A�� "+cnt[0]+"�� �Դϴ�.");
		System.out.println("B�� "+cnt[1]+"�� �Դϴ�.");
		System.out.println("C�� "+cnt[2]+"�� �Դϴ�.");
		System.out.println("D�� "+cnt[3]+"�� �Դϴ�.");
	}
}
