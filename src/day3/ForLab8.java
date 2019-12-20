package day3;

public class ForLab8 {

	public static void main(String[] args) {
		int num=0;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print((char)(65+num) );
				num++;
			}
			System.out.println();
		}

	}

}
