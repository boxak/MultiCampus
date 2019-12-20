package test;

public class Goods {
	String prodId; 	// 상품 아이디 
	String prodName; // 상품 이름 
	int price; 	// 상품 가격 
	char asYn; 	// AS 가능 여부 
	
	// 생성자 두 개를 구현하시오. 
	public Goods(String prodId,String prodName,int price) {
		this(prodId,prodName,price,'Y');
	}
	public Goods(String prodId,String prodName,int price,char asYn) {
		this.prodId=prodId;
		this.prodName=prodName;
		this.price=price;
		this.asYn=asYn;
	}
	
	// getGoodsInfo() 메서드를 구현하시오.
	
	public String getGoodsInfo() {
		if(asYn=='Y') {
			return String.format("상품ID: %s, 상품명 : %s, 가격 : %,d원, AS가능여부: 가능", prodId,prodName,price);
		}
		else {
			return String.format("상품ID: %s, 상품명 : %s, 가격 : %,d원, AS가능여부: 불가", prodId,prodName,price);
		}
	}
	
}
