package day3;

public class ForLab7 {

	public static void main(String[] args) {
		char star='*';
		for(int i=7;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(star);
			}
			System.out.println();
		}

	}

}
