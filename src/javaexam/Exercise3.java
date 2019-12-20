package javaexam;

class Car{
	String color;
	int door;
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("water!!!");
	}
}

class Ambulance extends Car{
	void siren() {
		System.out.println("siren~~~");
	}
}

public class Exercise3 {

	public static void main(String[] args) {
		/*
		Car car1 = null;
		FireEngine fe=new FireEngine();
		FireEngine fe2=null;
		fe.water();
		car1=fe; //car1=(Car)fe에서 형변환 생략된 형태
		fe2=(FireEngine)car1;
		fe2.water();
		System.out.println(fe);
		System.out.println(fe2);
		System.out.println(car1);*/
		Car car = new FireEngine();
		Car car2 = null;
		FireEngine fe = null;

		car.drive();
		fe = (FireEngine)car;
		fe.drive();
		car2=fe;
		car2.drive();
		doWork(car2);
		doWork(fe);
		doWork(car);
	}
	
	static void doWork(Car c) {
		if(c instanceof FireEngine) {
			FireEngine fe=(FireEngine)c;
			fe.water();
		}
		else {
			Ambulance a = (Ambulance)c;
			a.siren();
		}
	}
	
}
