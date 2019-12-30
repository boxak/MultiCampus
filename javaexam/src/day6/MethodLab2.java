package day6;

public class MethodLab2 {

	public static void main(String[] args) {
		int a1=(int)(Math.random()*30)+1;
		int a2=(int)(Math.random()*30)+1;
		System.out.println(a1+"와 "+a2+"의 차는 "+getDiff(a1,a2)+"입니다.");
	}
	static int getDiff(int a1,int a2) {
		//int result=을 사용해서 return 의 개수를 최소화할 수 있다.
		if(a1==a2) {
			return 0;
		}
		else if(a1>a2) {
			return a1-a2;
		}
		else {
			return a2-a1;
		}
	}
}
