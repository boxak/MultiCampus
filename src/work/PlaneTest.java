package work;

abstract class Plane{
	private String planeName;
	private int fuelSize;
	public Plane() {}
	public Plane(String planeName,int fuelSize) {
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	public String getPlaneName() {
		return planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	public abstract void flight(int distance);
	public void refuel(int fuel) {
		fuelSize+=fuel;
	}
}

class Airplane extends Plane{
	public Airplane() {}
	public Airplane(String planeName,int fuelSize) {
		super(planeName,fuelSize);
	}
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance/10)*30);
	}
}

class Cargoplane extends Plane{
	public Cargoplane() {}
	public Cargoplane(String planeName,int fuelSize) {
		super(planeName,fuelSize);
	}
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance/10)*50);
	}
}

public class PlaneTest {

	public static void main(String[] args) {
		Plane p[]=new Plane[2];
		p[0]=new Airplane("L747",1000);
		p[1]=new Cargoplane("C40",1000);
		printInfo(p);
		System.out.println("[100 운항]");
		p[0].flight(100);
		p[1].flight(100);
		printInfo(p);
		System.out.println("[200 주유]");
		p[0].refuel(200);
		p[1].refuel(200);
		printInfo(p);
	}
	public static void printInfo(Plane[] p) {
		System.out.println("Plane       fuelSize");
		System.out.println("----------------------------");
		System.out.println(p[0].getPlaneName()+"         "+p[0].getFuelSize());
		System.out.println(p[1].getPlaneName()+"          "+p[1].getFuelSize());
		System.out.println();
	}
}
