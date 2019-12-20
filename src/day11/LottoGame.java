package day11;

public class LottoGame {

	public static void main(String[] args) {
		
		LottoMachine lm= new LottoMachine();
		lm.createLottoNums();
		try {
			lm.checkLottoNums();
		}catch(DuplicateException e){
			System.out.println(e.getMessage());
			return;
		}
		int save[]=lm.getNums();
		for(int i=0;i<5;i++) {
			System.out.printf("%d, ", save[i]);
		}
		System.out.printf("%d%n", save[5]);

	}

}
