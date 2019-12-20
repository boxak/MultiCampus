package day13;

import java.util.*;

class Person{
	private String name;
	Person(String name){
		this.name=name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend extends Person{
	String phoneNum;
	String email;
	
	Friend(String name,String phoneNum,String email){
		super(name);
		this.phoneNum=phoneNum;
		this.email=email;
	}
	public String getInfo() {
		//return super.getInfo()+" "+phoneNum+" "+email;
		return String.format("%-20s%-20s%-20s%n", super.getInfo(),phoneNum,email);
	}
	
}

public class FreindTestLinkedList {

	public static void main(String[] args) {
		
		LinkedList <Friend> bestFriend=new LinkedList<>();
		bestFriend.add(new Friend("Ȳ����","010-2239-1506","boxak@naver.com"));
		bestFriend.add(new Friend("�����","010-1234-1111","ccddee@naver.com"));
		bestFriend.add(new Friend("�ö�Ҵ�","010-3333-1331","defgfdefd@naver.com"));
		bestFriend.add(new Friend("����","010-8282-2828","diudjksad@hanmail.net"));
		bestFriend.add(new Friend("������","010-3333-2222","ironman@naver.com"));
		System.out.println("�̸�                   ��ȭ��ȣ                              �����ּ�");
		System.out.println("-------------------------------------------------------");
		for(Friend f : bestFriend) {
			System.out.println(f.getInfo());
		}
		Iterator <Friend> iter = bestFriend.iterator();
		while(iter.hasNext()) {
			Friend s=iter.next();
			System.out.println(s.getInfo());
		}
	}

}
