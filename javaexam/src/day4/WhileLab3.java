package day4;

public class WhileLab3 {

	public static void main(String[] args) {
		int cnt=0;
		while(true) {
			int num=(int)(Math.random()*31);
			if(num==0 || (num>=27 && num<=30)) break;
			System.out.printf("%c(%d)\n",num+'A'-1,num);
			cnt++;
		}
		System.out.println("수행횟수는 "+cnt+"번 입니다.");
	}

}
