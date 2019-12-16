package mobile;

abstract class Mobile{
	private String mobileName;
	private int batterySize;
	private String osType;
	public Mobile() {
		
	}
	public Mobile(String mobileName,int batterySize,String osType) {
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
	public abstract void operate(int time); //전화기 배터리를 얼마나 소모하였는지 batterySize값을 계산한다.
	public abstract void charge(int time); //전화기 배터리를 얼마나 충전하였는지 batterySize값을 계산한다.
	public void getBattery(int charge) {
		batterySize+=charge;
	}
	public String setName() {
		return mobileName;
	}
	public int setBattery() {
		return batterySize;
	}
	public String setType() {
		return osType;
	}
}

class Ltab extends Mobile{
	public Ltab() {
		
	}
	public Ltab(String mobileName,int batterySize,String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {
		getBattery(-time*10);
	}
	public void charge(int time) {
		getBattery(time*10);
	}
}

class Otab extends Mobile{
	public Otab() {
		
	}
	public Otab(String mobileName,int batterySize,String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {
		getBattery(-time*12);
	}
	public void charge(int time) {
		getBattery(time*8);
	}
}

public class MobileTest {

	public static void main(String[] args) {

		Ltab m1=new Ltab("Ltab",500,"ABC-01");
		Otab m2=new Otab("Otab",1000,"XYZ-20");
		printTitle();
		printMobile(m1);
		printMobile(m2);
		System.out.println();
		System.out.println("[10분 충전]");
		printTitle();
		m1.charge(10);
		m2.charge(10);
		printMobile(m1);
		printMobile(m2);
		System.out.println();
		System.out.println("[5분 통화]");
		printTitle();
		m1.operate(5);
		m2.operate(5);
		printMobile(m1);
		printMobile(m2);
	}
	
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.setName()+"        "+mobile.setBattery()+"        "+mobile.setType());
	}
	public static void printTitle() {
		System.out.println("Mobile     Battery     OS");
		System.out.println("---------------------------------");
	}
}
