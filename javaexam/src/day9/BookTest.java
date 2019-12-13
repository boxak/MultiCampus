package day9;

class Book{
	String title;
	String author;
	private int price;
	Book(){
		/*
		title="Java의 정석";
		author="남궁성";
		price=30000;
		*/
		this("Java의 정석","남궁성",30000);
	}
	Book(String title,String author,int price){
		this.title=title; //this는 class의 멤버 변수들의 참조값들을 가지고 있다. 자신의 객체의 참조값을 의미하는 리터럴
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
		Book b1=new Book("자바의 정석","남궁성",-30000);
		b1.setPrice(-33000);
		
		System.out.println(b1.getBookInfo());
		
	}

}
