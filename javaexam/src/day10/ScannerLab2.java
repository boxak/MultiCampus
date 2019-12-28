package day10;
import java.util.Scanner;
public class ScannerLab2 {

	public static void main(String[] args) {
		int a,b;
		int result=0;
		boolean flag=false;
		String operator;
		Scanner sc=new Scanner(System.in);
		//숫자와 연산자를 입력받아 처리하는 기능을 3번 반복하도록 바꿔보기.
		int cnt=3;
		while(cnt-->0) {
			flag=false;
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			a=sc.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			b=sc.nextInt();
			System.out.print("연산자(+,-,*,/)를 입력하세요 : ");
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
				System.out.printf("%d 와 %d의 %s 연산 결과는 %d입니다.%n",a,b,operator,result);
			}
			else {
				System.out.println("+,-,*,/를 입력하숑");
			}
		}
		System.out.println("연산이 종료되었습니다.");
		sc.close();
	}

}