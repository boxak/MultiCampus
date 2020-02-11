package day7;

class Product{
	String name;
	int balance;
	int price;
	Product(){
		this("��ũ����",5,10000);
	}
	Product(String name,int balance,int price){
		this.name=name;
		this.balance=balance;
		this.price=price;
	}
	String getName() { //����ƽ ���̸� �ȵ�.
		return name;
	}
	int getBalance() {
		return balance;
	}
	int getPrice() {
		return price;
	}
}

public class ProductTest {

	public static void main(String[] args) {
		Product p1=new Product();
		Product p2=new Product("������",3,150000);
		Product p3=new Product("������",2,90000);
		Product p4=new Product("����",7,50000);
		Product p5=new Product("û����",10,45000);
		Product p_set[]=new Product[] {p1,p2,p3,p4,p5};
		for(int i=0;i<5;i++) {
			System.out.printf("%s %d %,d��%n",p_set[i].getName(),p_set[i].getBalance(),p_set[i].getPrice());
		}
		for(Product data : p_set) {
			System.out.printf("%s %d %,d��%n",data.getName(),data.getBalance(),data.getPrice());
		}
	}

}
