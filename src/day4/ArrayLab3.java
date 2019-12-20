package day4;

public class ArrayLab3 {

	public static void main(String[] args) {
		char Letters[]=new char[4];
		Letters[0]='J';
		Letters[1]='a';
		Letters[2]='v';
		Letters[3]='a';
		char newLetters[]=new char[4];
		for(int i=0;i<Letters.length;i++) {
			if(Letters[i]>=65 && Letters[i]<=90) {
				newLetters[i]=(char)((int)Letters[i]+32);
			}
			else if(Letters[i]>=97 && Letters[i]<=122) {
				newLetters[i]=(char)((int)Letters[i]-32);
			}
		}
		System.out.println(newLetters);
	}

}
