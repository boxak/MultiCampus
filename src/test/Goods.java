package test;

public class Goods {
	String prodId; 	// ��ǰ ���̵� 
	String prodName; // ��ǰ �̸� 
	int price; 	// ��ǰ ���� 
	char asYn; 	// AS ���� ���� 
	
	// ������ �� ���� �����Ͻÿ�. 
	public Goods(String prodId,String prodName,int price) {
		this(prodId,prodName,price,'Y');
	}
	public Goods(String prodId,String prodName,int price,char asYn) {
		this.prodId=prodId;
		this.prodName=prodName;
		this.price=price;
		this.asYn=asYn;
	}
	
	// getGoodsInfo() �޼��带 �����Ͻÿ�.
	
	public String getGoodsInfo() {
		if(asYn=='Y') {
			return String.format("��ǰID: %s, ��ǰ�� : %s, ���� : %,d��, AS���ɿ���: ����", prodId,prodName,price);
		}
		else {
			return String.format("��ǰID: %s, ��ǰ�� : %s, ���� : %,d��, AS���ɿ���: �Ұ�", prodId,prodName,price);
		}
	}
	
}
