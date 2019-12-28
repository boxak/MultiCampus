package day4;

public class ArrayLab1 {

	public static void main(String[] args) {
		int ary[]=new int[10];
		for(int i=0;i<ary.length;i++) {
			System.out.printf("%d ",ary[i]);
		}
		System.out.println();
		for(int i=0;i<ary.length;i++) {
			ary[i]=(i+1)*10;
		}
		for(int i=0;i<ary.length;i++) {
			System.out.printf("%d ",ary[i]);
		}
		System.out.println();
		for(int i=ary.length-1;i>=0;i--) {
			System.out.printf("%d ",ary[i]);
		}
		System.out.println();
		for(int i=0;i<ary.length;i++) {
			if(i%2==1) {
				System.out.printf("%d ",ary[i]);
			}
		}
	}

}
