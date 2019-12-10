package day5;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		int Array[][]=new int [4][];
		Array[0]=new int[5];
		Array[1]=new int[3];
		Array[2]=new int[4];
		Array[3]=new int[9];
		
		for(int i=0;i<Array.length;i++) {
			switch(i) {
				case 0 : 
					for(int j=0;j<Array[i].length;j++) {
						Array[i][j]=(j+1)*10;
					}
					break;
				case 1 :
					for(int j=0;j<Array[i].length;j++) {
						Array[i][j]=(j+1)*5;
					}
					break;
				case 2 :
					for(int j=0;j<Array[i].length;j++) {
						Array[i][j]=(j+1)*11;
					}
					break;
				case 3:
					for(int j=0;j<Array[i].length;j++) {
						Array[i][j]=Array[i].length-j;
					}
			}
		}
		int sum=0;
		for(int row=0;row<Array.length;row++) {
			sum=0;
			for(int col=0;col<Array[row].length;col++) {
				sum+=Array[row][col];
			}
			System.out.println(row+1+"행의 합은 "+sum+"입니다.");
		}
				
	}

}
