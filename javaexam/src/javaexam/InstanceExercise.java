package javaexam;

class Tv{
	String color;
	boolean power;
	int channel;
	/*
	Tv(String color,boolean power,int channel){
		this.color=color;
		this.power=power;
		this.channel=channel;
	}*/
	
	void power() {
		power=!power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}

public class InstanceExercise {

	public static void main(String[] args) {
		//��ü �迭 �ٷ��
		//�� ���� ���� new Tv()�� �������༭ �̿��� �� �ִ�.
		
		Tv[] tvArr=new Tv[100];
		
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i]=new Tv();
			tvArr[i].channel=i+10;
		}
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		}
		
	}

}
