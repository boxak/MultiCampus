package day3;

public class ForLab2 {

	public static void main(String[] args) {
		int number=(int)(Math.random()*9)+1;
		switch(number%2) {
			case 0: 
				System.out.println(number+" : Â¦¼ö");
				break;
			case 1:
				System.out.println(number+" : È¦¼ö");
		}
	}

}
