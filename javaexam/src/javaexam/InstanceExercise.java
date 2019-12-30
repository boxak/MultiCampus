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
		//객체 배열 다루기
		//각 원소 별로 new Tv()를 선언해줘서 이용할 수 있다.
		
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
