package day4;

public class ArrayLab4 {

	public static void main(String[] args) {
		int Array[]=new int[10];
		for(int i=0;i<10;i++) {
			Array[i]=(int)(Math.random()*26)+1;
		}
		char Letters[]=new char[10];
		for(int i=0;i<10;i++) {
			Letters[i]=(char)(Array[i]-1+(int)'A');
		}
		for(int i=0;i<9;i++) {
			System.out.printf("%d,", Array[i]);
		}
		System.out.println(Array[Array.length-1]);
		for(int i=0;i<9;i++) {
			System.out.printf("%c,", Letters[i]);
		}
		System.out.println(Letters[9]);
	}

}
