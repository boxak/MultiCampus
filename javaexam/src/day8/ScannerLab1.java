package day8;
import java.util.Scanner;
public class ScannerLab1 {

	public static void main(String[] args) {
		int a,b;
		int result=0;
		boolean flag=false;
		String operator;
		Scanner sc=new Scanner(System.in);
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
		sc.close();
	}

}
