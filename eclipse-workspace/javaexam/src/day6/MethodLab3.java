package day6;

public class MethodLab3 {

	public static void main(String[] args) {
		for(int i=0;i<4;i++) {
			System.out.printf("%d, ",getRandom(10));
		}
		System.out.printf("%d\n",getRandom(10));
		for(int i=0;i<4;i++) {
			System.out.printf("%d, ",getRandom(10,20));
		}
		System.out.printf("%d\n",getRandom(10,20));
	}
	public static int getRandom(int n) {
		return (int)(Math.random()*n)+1;
	}
	public static int getRandom(int n1,int n2) { //오버로딩
		int big;
		int small;
		if(n1>n2) {
			big=n1;small=n2;
		}
		else {
			big=n2;small=n1;
		}
		return (int)(Math.random()*(big-small+1))+(small);
	}
}
