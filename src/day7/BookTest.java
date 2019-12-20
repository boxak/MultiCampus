package day7;

class Book{
	String title;
	String author;
	int price;
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
		this.price=price;
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
		Book b2=new Book("�ճ��� �̿�����","�̿���",15000);
		Book b3=new Book("������ ������","����������",7200);
		Book b4=new Book("1984","��������",8500);
		Book b5=new Book("���η�","�ִ� ���̽�",10000);
		System.out.println(b1.getBookInfo());
		System.out.println(b2.getBookInfo());
		System.out.println(b3.getBookInfo());
		System.out.println(b4.getBookInfo());
		System.out.println(b5.getBookInfo());
		
	}

}
