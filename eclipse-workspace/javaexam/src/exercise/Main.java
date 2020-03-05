package exercise;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int N;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		char [][] map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String temp [] = new String[N];
			temp = scan.nextLine().split("");
			for(int j=0;j<temp.length;j++) {
				map[i][j] = temp[j].charAt(0);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.println(map[i][j]+" ");
			}
			System.out.println();
		}
		scan.close();
	}

}
