package test;
public class PrintAlpha {
	public static void main(String[] args) {
		
		String letters="ABCDEFGHIJKLMNO";
		int inx=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.printf("%c", letters.charAt(inx));
				inx++;
			}
			System.out.println();
		}

	}
}
