package day11.case3;

public class TVUser {
	public static void main(String[] args) {		
		TV tv = TVFactory.getTV(args[0]); //argument를 안줬기 때문에 에러가 난다.
		if(tv != null) {
			tv.powerOn();
			tv.volumnUp();
			tv.volumnDown();
			tv.powerOff();
		} else {
			System.out.println("프로그램 아규먼트로 samsung 또는 lg 를 입력해 주세요..");
		}
		//고객이 원하는 대로 사양을 바꿀 수 있다.
	}
}
