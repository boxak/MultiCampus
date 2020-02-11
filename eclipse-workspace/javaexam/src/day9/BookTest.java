package day9;

class Book{
	String title;
	String author;
	private int price;
	Book(){
		/*
		title="Java�� ����";
		author="���ü�";
		price=30000;
		*/
		this("Java�� ����","���ü�",30000);
	}
	Book(String title,String author,int price){
		this.title=title; //this�� class�� ��� �������� ���������� ������ �ִ�. �ڽ��� ��ü�� �������� �ǹ��ϴ� ���ͷ�
		this.author=author; //
		if(price<0) this.price=-price;
		else this.price=price;
	}
	
	void setPrice(int price) {
		if(price<0) {
			this.price=-price;
		}
		else {
			this.price=price;
		}
	}
	
	String getBookInfo() {
		String temp="";
		temp=title+" "+author+" "+Integer.toString(price);
		return temp;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book b1=new Book("�ڹ��� ����","���ü�",-30000);
		b1.setPrice(-33000);
		
		System.out.println(b1.getBookInfo());
		
	}

}
