package day2;
import java.util.Random;
public class SwitchLAb1 {

	public static void main(String[] args) {
		
		Random rand=new Random();
		int grade=rand.nextInt(6);
		
		switch(grade) {
			case 1:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
			case 2:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
			case 3:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
			case 4:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
			case 5:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
			case 6:
				System.out.println(grade+"�г��� ���г��Դϴ�.");
				break;
		}
		
	}

}
