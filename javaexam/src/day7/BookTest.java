package day7;

class Book{
	String title;
	String author;
	int price;
	Book(){
		title="Java의 정석";
		author="남궁성";
		price=30000;
	}
	Book(String p1,String p2,int p3){
		title=p1;
		author=p2;
		price=p3;
	}
	String getBookInfo() {
		String temp="";
		temp=title+" "+author+" "+Integer.toString(price);
		return temp;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book b1=new Book();
		Book b2=new Book("먼나라 이웃나라","이원복",15000);
		Book b3=new Book("위대한 개츠비","피츠제럴드",7200);
		Book b4=new Book("1984","조지오웰",8500);
		Book b5=new Book("국부론","애덤 스미스",10000);
		System.out.println(b1.getBookInfo());
		System.out.println(b2.getBookInfo());
		System.out.println(b3.getBookInfo());
		System.out.println(b4.getBookInfo());
		System.out.println(b5.getBookInfo());
		
	}

}
