package day3;

public class ForLab3 {

	public static void main(String[] args) {
		int number1=(int)(Math.random()*10)+1;
		int number2=(int)(Math.random()*11)+30;
		int sum=0;
		for(int num=number1;num<=number2;num++) {
			if(num%2==0) sum+=num;
		}
		System.out.print(number1+"부터 "+number2+" 까지의 합 : "+sum);
	}

}
