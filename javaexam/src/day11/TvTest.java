package day11;

public class TvTest {

	public static void main(String[] args) {
		
		TV s1=new SaleTV(300000,"SALETV-1",40,1);
		TV r1=new RentalTV(100000,"RENTALTV-10",42,1);
		
		for(int i=1;i<=2;i++) s1.channelUp();
		for(int i=1;i<=3;i++) r1.channelDown();
		printAllTV(s1);
		printAllTV(r1);
		printRentalTV((Rentable)r1);
	}
	
	static void printAllTV(TV tv) {
		if(tv instanceof SaleTV) {
			System.out.println(((SaleTV)tv).toString());
			((SaleTV)tv).play(); // -> TV�� ������ play,sale�� ȣ���Ϸ��� ���� ����ȯ�� �ؼ� �����ؾ� �Ѵ�.
			((SaleTV)tv).sale();
		}
		else {
			System.out.println(((RentalTV)tv).toString());
			((RentalTV)tv).play();
		}
		
	}
	
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}

}
