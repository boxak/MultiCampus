package day2;

public class SwitchLab2 {

	public static void main(String[] args) {
		int det=(int)(Math.random()*5)+1;
		switch(det){
			case 1 : System.out.print(300+50);
				break;
			case 2 : System.out.print(300-50);
				break;
			case 3 : System.out.print(300*50);
				break;
			case 4 : System.out.print(300/50);
				break;
			case 5 : System.out.print(300%50);
		}

	}

}
