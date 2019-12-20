package day11;

class SaleTV extends TV{
	private int price;
	public SaleTV() {}
	public SaleTV(int price,String model,int size,int channel) {
		super(model,size,channel);
		this.price=price;
	}
	public void play() {
		System.out.println("�Ǹ� TV ä�� "+super.getChannel()+"���� ���θ� �÷����մϴ�.");
	}
	public void sale() {
		System.out.printf("%s ���� ��ǰ�� �Ǹ��մϴ�. %,d���� �������ּ���.%n",super.getModel(),price);
	}		
	public String toString() {
		return String.format("�ǸŻ�ǰ���� : �𵨸� (%s), ����(%,d��), ũ��(%d)",super.getModel(),price,super.getSize());
	}
}
