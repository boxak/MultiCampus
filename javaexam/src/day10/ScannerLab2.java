package day10;
import java.util.Scanner;
public class ScannerLab2 {

	public static void main(String[] args) {
		int a,b;
		int result=0;
		boolean flag=false;
		String operator;
		Scanner sc=new Scanner(System.in);
		//���ڿ� �����ڸ� �Է¹޾� ó���ϴ� ����� 3�� �ݺ��ϵ��� �ٲ㺸��.
		int cnt=3;
		while(cnt-->0) {
			flag=false;
			System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
			a=sc.nextInt();
			System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
			b=sc.nextInt();
			System.out.print("������(+,-,*,/)�� �Է��ϼ��� : ");
			operator=sc.next();
			switch(operator) {
				case "+":
					result=a+b;
					flag=true;
					break;
				case "-":
					result=a-b;
					flag=true;
					break;
				case "/":
					result=a/b;
					flag=true;
					break;
				case "*":
					result=a*b;
					flag=true;
					break;
			}
			if(flag) {
				System.out.printf("%d �� %d�� %s ���� ����� %d�Դϴ�.%n",a,b,operator,result);
			}
			else {
				System.out.println("+,-,*,/�� �Է��ϼ�");
			}
		}
		System.out.println("������ ����Ǿ����ϴ�.");
		sc.close();
	}

}