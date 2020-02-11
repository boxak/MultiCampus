package day5;

public class LottoMachine1 {

	public static void main(String[] args) {
		int [] numbers=new int[6];
		boolean [] visited=new boolean[46];
		for(int i=1;i<=45;i++) {
			visited[i]=false;
		}
		for(int i=0;i<6;i++) {
			while(true) {
				numbers[i]=(int)(Math.random()*45)+1;
				if(visited[numbers[i]]==false) {
					visited[numbers[i]]=true;
					break;
				}
			}
		}
		System.out.print("오늘의 로또 번호 - ");
		for(int i=0;i<5;i++) {
			System.out.print(numbers[i]+", ");
		}
		System.out.print(numbers[5]);
	}

}
