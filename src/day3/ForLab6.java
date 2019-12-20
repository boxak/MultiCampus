package day3;

public class ForLab6 {

	public static void main(String[] args) {
		char shape='&';
		int floor=(int)(Math.random()*5)+5;
		for(int i=1;i<=floor;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(shape);
			}
			System.out.println();
		}
	}

}
