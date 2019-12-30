package day11;

class SaleTV extends TV{
	private int price;
	public SaleTV() {}
	public SaleTV(int price,String model,int size,int channel) {
		super(model,size,channel);
		this.price=price;
	}
	public void play() {
		System.out.println("판매 TV 채널 "+super.getChannel()+"번의 프로를 플레이합니다.");
	}
	public void sale() {
		System.out.printf("%s 모델의 상품을 판매합니다. %,d원을 지불해주세요.%n",super.getModel(),price);
	}		
	public String toString() {
		return String.format("판매상품정보 : 모델명 (%s), 가격(%,d원), 크기(%d)",super.getModel(),price,super.getSize());
	}
}
