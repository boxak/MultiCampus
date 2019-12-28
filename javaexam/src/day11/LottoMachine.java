package day11;
import java.util.Random;

class DuplicateException extends Exception{
	DuplicateException(){
		super("중복된 로또 번호가 발생했습니다."); //예외 메세지로 세팅해주는 구문 -> getMessage로 호출
	}
}

class LottoMachine {
	
	private int nums[];
	public LottoMachine() {
		nums=new int[6];
	}
	public void createLottoNums() {
		Random rand=new Random();
		for(int i=0;i<6;i++) {
			nums[i]=rand.nextInt(20)+1;
		}
	}
	public void checkLottoNums() throws DuplicateException {
		//throws 구문은 예외가 있을 수 있음을 외부에 알리는 구문이다. 발생시키는 구문이 아님.
		//다른 예외구문은 대비하지 못한다.
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(nums[i]==nums[j]) {
					throw new DuplicateException(); //throw 뒤에는 예외 객체만 올 수 있다.
					//예외가 발생했을 경우 바로 for문을 빠져나간다.
				}
			}
		}
	}
	public int[] getNums() {
		return nums;
	}
}
