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
		System.out.println("1���� 100������ ���ڵ� �߿���");
		System.out.println("¦���� ���� "+evenNum+"�̰�");
		System.out.println("Ȧ���� ���� "+oddNum+"�̴�.");

	}

}
