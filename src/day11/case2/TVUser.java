package day11.case2;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new LgTV(); //TV 인터페이스를 상속하는 객체만 올 수 있다.
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}

}
