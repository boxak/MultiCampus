package day9;

class Multiplication {
	private int dan;
	private int number;
	Multiplication() {}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	public void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication{
	GuGuDanExpr(){
		
	}
	GuGuDanExpr(int dan){
		super(dan);
	}
	GuGuDanExpr(int dan,int number){
		super(dan,number);
	}
	public static void printAll() { //조상에 있는 printPart를 쓰는 것은 ㄴㄴ
		for(int dan=1;dan<=9;dan++) {
			for(int number=1;number<=9;number++) {
				System.out.printf("%d * %d = %d   ",dan,number,dan*number);
			}
			System.out.println();
		}
	}
}

public class GuGuDan {

	public static void main(String[] args) {
		int dan=day6.MethodLab3.getRandom(20);
		int number=day6.MethodLab3.getRandom(20);
		//System.out.printf("%d, %d%n", dan,number);
		GuGuDanExpr gugu;
		if(1<=dan && dan<=9 && 1<=number && number<=9) {
			gugu=new GuGuDanExpr(dan,number);
			gugu.printPart();
		}
		else if(1<=dan && dan<=9 && number>=10) {
			gugu=new GuGuDanExpr(dan,0);
			gugu.printPart();
		}
		else {
			GuGuDanExpr.printAll();
		}
		
	}

}
