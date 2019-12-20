package day12;
public class IntegerTest {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("프로그램 아규먼트 2개를 숫자로 입력하세요");
		} else {
			System.out.println(Integer.parseInt(args[0])
					 +Integer.parseInt(args[1]));
		}
		String s1 = Integer.toBinaryString(12); //주어진 정수형 십진수를 이진수 문자열로 바꿔줌. 
		String s2 = Integer.toBinaryString(88);
	    
		System.out.printf("%s\n", s1);
		System.out.printf("%s\n", s2);
		
		int num1 = Integer.parseInt(s1 ,2); //-> 문자열 1100 뒤에 2라는 아규먼트 주면 이진수로 1100이라고 알려주는 것임.
		int num2 = Integer.parseInt(s2, 2); 
		
		System.out.printf("%d\n", num1);
		System.out.printf("%d\n", num2);
	}
}
