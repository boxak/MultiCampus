package day3;

public class ForLab4 {

	public static void main(String[] args) {
		
		int num1=(int)(Math.random()*8)+3;
		int num2=(int)(Math.random()*3)+1;
		switch(num2) {
			case 1 :
				for(int i=0;i<num1;i++) {
					System.out.print('*');
				}
				break;
			case 2 :
				for(int i=0;i<num1;i++) {
					System.out.print('$');
				}
				break;
			case 3:
				for(int i=0;i<num1;i++) {
					System.out.print('#');
				}
				break;
		}
		System.out.println();

	}

}
