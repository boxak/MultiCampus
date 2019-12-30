package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		int end=(int)(Math.random()*6)+5;
		for(int i=1;i<=end;i++) {
			System.out.println(i+" -> "+i*i);
		}
		int start=1;
		while(start<=end) {
			System.out.println(start+" -> "+start*start);
			start++;
		}
		
	}

}
