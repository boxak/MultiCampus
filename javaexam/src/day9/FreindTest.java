package day9;

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

public class FreindTest {

	public static void main(String[] args) {
		Friend bestFriend[]=new Friend[5];
		bestFriend[0]=new Friend("Ȳ����","010-2239-1506","boxak@naver.com");
		bestFriend[1]=new Friend("���ӽ�","010-1234-1111","ccddee@naver.com");
		bestFriend[2]=new Friend("�뵵����","010-4444-7777","fedgdf@naver.com");
		bestFriend[3]=new Friend("�����","010-0000-1111","sossocs@naver.com");
		bestFriend[4]=new Friend("�ö�Ҵ�","010-3333-1331","defgfdefd@naver.com");
		System.out.println("�̸�                   ��ȭ��ȣ                              �����ּ�");
		System.out.println("-------------------------------------------------------");
		for(int i=0;i<5;i++) {
			System.out.println(bestFriend[i].getInfo());
		}
	}

}
