package day6;

public class MethodTest4 {

	public static void main(String[] args) {
		System.out.println("main() �������");
		System.out.println(args.length);
		printMyName(3,'*');
		System.out.println("------------");
		printName("Duke",'$');
		printName("Duke",'$');
		printName("Duke",'$');
		System.out.println("------------");
		printName("Taxi",'!');
		System.out.println("------------");
		System.out.println("main() ��������");
	}
	static void printMyName(int num,char deco) {
		for(int i=0;i<num;i++) {
			System.out.println(deco+"������"+deco);
		}
	}
	static void printName(String name,char deco) {
		System.out.println(deco+name+deco);
	}

}
