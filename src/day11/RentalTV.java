package day11;

class RentalTV extends TV implements Rentable{
	int price;
	public RentalTV() {}
	public RentalTV(int price,String model,int size,int channel) {
		super(model,size,channel);
		this.price=price;
	}
	public void play() {
		System.out.println("대여 TV 채널 "+super.getChannel()+"번의 프로를 플레이합니다.");
	}
	public String toString() {
		return String.format("대여상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", super.getModel(),price,super.getSize());
	}
	public void rent() {
		System.out.printf("%s 모델의 상품을 대여합니다. %,d원을 지불해주세요.%n",super.getModel(),price);
	}
}
