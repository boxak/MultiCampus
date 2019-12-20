package day3;

public class WhileLab2 {

	public static void main(String[] args) {
		int pairNum1=(int)(Math.random()*6)+1;
		int pairNum2=(int)(Math.random()*6)+1;
		while(pairNum1!=pairNum2) {
			pairNum1=(int)(Math.random()*6)+1;
			pairNum2=(int)(Math.random()*6)+1;
			if(pairNum1>pairNum2) {
				System.out.println("pairNum1이 pairNum2보다 크다");
			}
			else if(pairNum1<pairNum2) {
				System.out.println("pairNum1이 pairNum2보다 작다");
			}
		}
		System.out.println("게임 끝");
	}

}
