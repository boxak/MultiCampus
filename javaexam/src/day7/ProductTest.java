package day7;

class Product{
	String name;
	int balance;
	int price;
	Product(){
		this("듀크인형",5,10000);
	}
	Product(String name,int balance,int price){
		this.name=name;
		this.balance=balance;
		this.price=price;
	}
	String getName() { //스태틱 붙이면 안됨.
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
		Product p2=new Product("에어팟",3,150000);
		Product p3=new Product("자전거",2,90000);
		Product p4=new Product("가방",7,50000);
		Product p5=new Product("청바지",10,45000);
		Product p_set[]=new Product[] {p1,p2,p3,p4,p5};
		for(int i=0;i<5;i++) {
			System.out.printf("%s %d %,d원%n",p_set[i].getName(),p_set[i].getBalance(),p_set[i].getPrice());
		}
		for(Product data : p_set) {
			System.out.printf("%s %d %,d원%n",data.getName(),data.getBalance(),data.getPrice());
		}
	}

}
