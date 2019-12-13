package day8;

public class merge {

	public static void main(String[] args) {
		int [] numArr=new int [1000];
		makeRandom(numArr);
		printArr(numArr);
		mergeSort(numArr,0,numArr.length-1);
		printArr(numArr);

	}
	static void mergeSort(int [] Array,int start,int end) {
		if(start>=end) {
			return;
		}
		else {
			int mid=(start+end)/2;
			mergeSort(Array,start,mid);
			mergeSort(Array,mid+1,end);
			merging(Array,start,mid,mid+1,end);
		}
	}
	static void merging(int [] Array,int s1,int e1,int s2,int e2) {
		int p=s1;
		int q=s2;
		int inx=0;
		int tempArr[]=new int[Array.length];
		while(p<=e1 && q<=e2) {
			if(Array[p]<Array[q]) {
				tempArr[inx++]=Array[p];
				p++;
			}
			else {
				tempArr[inx++]=Array[q];
				q++;
			}
		}
		while(p<=e1) {
			tempArr[inx++]=Array[p];
			p++;
		}
		while(q<=e2) {
			tempArr[inx++]=Array[q];
			q++;
		}
		for(int i=0;i<inx;i++) {
			Array[s1+i]=tempArr[i];
		}
	}
	static void makeRandom(int [] Arr) {
		for(int i=0;i<Arr.length;i++) {
			Arr[i]=(int)(Math.random()*10000)+1;
		}
	}
	static void printArr(int [] Arr) {
		for(int i=0;i<Arr.length;i++) {
			System.out.printf("%d ",Arr[i]);
		}
		System.out.println();
	}

}
