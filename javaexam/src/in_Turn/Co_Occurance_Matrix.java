package in_Turn;
import java.util.Scanner;
public class Co_Occurance_Matrix {

	public static void main(String[] args) {
		
		int mat[][]=new int [20][20];
		Scanner scan=new Scanner(System.in);
		int n=0;
		int m=0;
		System.out.print("Input row-size and col-size : ");
		n=scan.nextInt();
		m=scan.nextInt();
		System.out.println("Input the elements");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				mat[i][j]=scan.nextInt();
			}
		}
		double result[][]=new double [20][20];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				result[i][j]=0;
			}
		}
		PPMI(result,mat,n,m);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.printf("%.2f ", result[i][j]);
			}
			System.out.println();
		}
	}
	
	static void PPMI(double result[][],int mat[][],int n,int m) {
		double p_tc=0;
		double p_t=0;
		int totalSum=0;
		int rowSum[]=new int [100];
		int colSum[]=new int [100];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				totalSum+=mat[i][j];
			}
		}
		for(int i=1;i<=n;i++) {
			rowSum[i]=0;
			for(int j=1;j<=m;j++) {
				rowSum[i]+=mat[i][j];
			}
		}
		for(int j=1;j<=m;j++) {
			colSum[j]=0;
			for(int i=1;i<=n;i++) {
				colSum[j]+=mat[i][j];
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				p_tc=(double)mat[i][j]/colSum[j];
				p_t=(double)rowSum[i]/totalSum;
				result[i][j]=Math.max(0.0f,Log(p_tc/p_t,2));
			}
		}
	}
	
	static double Log(double x,double base) {
		return Math.log10(x)/Math.log10(base);
	}
	
}
