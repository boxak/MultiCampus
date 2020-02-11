package day2;

public class TimeTest {

	public static void main(String []args) {
		int time=32150;
		int Hour=time/3600;
		time=time%3600;
		int Minute=time/60;
		time=time%60;
		int Second=time;
		System.out.print(Hour+"시간 "+Minute+"분 "+Second+"초");
	}

}
