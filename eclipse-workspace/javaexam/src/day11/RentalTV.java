package day11;

class RentalTV extends TV implements Rentable{
	int price;
	public RentalTV() {}
	public RentalTV(int price,String model,int size,int channel) {
		super(model,size,channel);
		this.price=price;
	}
	public void play() {
		System.out.println("�뿩 TV ä�� "+super.getChannel()+"���� ���θ� �÷����մϴ�.");
	}
	public String toString() {
		return String.format("�뿩��ǰ���� : �𵨸�(%s), ����(%,d), ũ��(%d)", super.getModel(),price,super.getSize());
	}
	public void rent() {
		System.out.printf("%s ���� ��ǰ�� �뿩�մϴ�. %,d���� �������ּ���.%n",super.getModel(),price);
	}
}
