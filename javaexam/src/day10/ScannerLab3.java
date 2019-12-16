package day10;
import java.util.Scanner;
public class ScannerLab3 {

	public static void main(String[] args) {
		int a,b;
		int result=0;
		boolean flag=false;
		String operator;
		Scanner sc=new Scanner(System.in);
		//숫자와 연산자를 입력받아 처리하는 기능을 사용자가
		//원할 때까지 반복하도록 코드 추가
		//결과 출력 후 사용자에게 계속 수행하겠는지에 대한 메세지를 출력하고
		//1을 입력 -> 계속 수행, 다른 숫자면 종료
		
		while(true) {
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
			System.out.print("연산을 계속 수행하시겠습니까? (y입력 : 계속 수행,  다른값 : 수행종료) : ");
			if(!sc.next().equals("y")) break;
		}
		sc.close();
	}

}