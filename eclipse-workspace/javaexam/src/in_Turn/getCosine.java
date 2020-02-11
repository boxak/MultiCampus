package in_Turn;

public class getCosine {

	public static void innerProduct(double arr[][],double result[][],int n,int m) {
		
		double rowSum=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				rowSum=0;
				for(int k=1;k<=m;k++) {
					rowSum+=arr[i][k]*arr[j][k];
					//System.out.println("row : "+i+" "+j+"/col : "+k);
				}
				result[i][j]=rowSum/(rootSumOfSquare(arr[i],m)*rootSumOfSquare(arr[j],m));
			}
		}
		
	}
	static double rootSumOfSquare(double arr[],int m) {
		double sum=0;
		for(int i=1;i<=m;i++) {
			sum+=arr[i]*arr[i];
		}
		return Math.sqrt(sum);
	}

}
