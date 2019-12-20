package day6;

public class MethodTest7_2 {

	public static void main(String[] args) { //main은 자바 인터프리터가 호출해준다.
		int result=0;
		for(int i=0;i<args.length;i++) {
			result+=Integer.parseInt(args[i]);
		}
		System.out.println(result);
	}
	

}
