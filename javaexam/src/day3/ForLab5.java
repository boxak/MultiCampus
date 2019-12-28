package day3;

public class ForLab5 {

	public static void main(String[] args) {
		int evenNum=0;
		int oddNum=0;
		for(int i=1;i<=100;i++) {
			switch(i%2) {
				case 0:
					evenNum+=i;
					break;
				case 1:
					oddNum+=i;
					break;
			}
		}
		System.out.println("1부터 100까지의 숫자들 중에서");
		System.out.println("짝수의 합은 "+evenNum+"이고");
		System.out.println("홀수의 합은 "+oddNum+"이다.");

	}

}
