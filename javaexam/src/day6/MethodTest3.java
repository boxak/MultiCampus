package day6;

public class MethodTest3 {

	public static void main(String[] args) {
		System.out.println("main() �������");
		printMyName(1,'��');
		System.out.println("--------------");
		printMyName(3,'*');
		System.out.println("--------------");
		printMyName(2,'@');
		System.out.println("--------------");
		System.out.println("main() ��������");
	}
	static void printMyName(int num,char deco) {
		for(int i=0;i<num;i++) {
			System.out.println(deco+"������"+deco);
		}
	}

}