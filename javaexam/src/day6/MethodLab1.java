package day6;

public class MethodLab1 {

	public static void main(String[] args) {
		printLetter('@',3);
		printLetter('%',4);
		printLetter('A',5);
		printLetter('°¡',3);
	}
	static void printLetter(char a,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(a);
		}
		System.out.println();
	}
}
