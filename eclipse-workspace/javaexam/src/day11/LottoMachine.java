package day11;
import java.util.Random;

class DuplicateException extends Exception{
	DuplicateException(){
		super("�ߺ��� �ζ� ��ȣ�� �߻��߽��ϴ�."); //���� �޼����� �������ִ� ���� -> getMessage�� ȣ��
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
		//throws ������ ���ܰ� ���� �� ������ �ܺο� �˸��� �����̴�. �߻���Ű�� ������ �ƴ�.
		//�ٸ� ���ܱ����� ������� ���Ѵ�.
		for(int i=0;i<6;i++) {
			for(int j=i+1;j<6;j++) {
				if(nums[i]==nums[j]) {
					throw new DuplicateException(); //throw �ڿ��� ���� ��ü�� �� �� �ִ�.
					//���ܰ� �߻����� ��� �ٷ� for���� ����������.
				}
			}
		}
	}
	public int[] getNums() {
		return nums;
	}
}
