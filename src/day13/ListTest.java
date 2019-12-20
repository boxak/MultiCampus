package day13;
import java.util.ArrayList;

class CreateList{
	public ArrayList<Integer> convertList(int Array[]) {
		ArrayList<Integer> tmp=new ArrayList<>(20);
		for(int i=Array.length-1;i>=0;i--) {
			tmp.add(Array[i]);
		}
		return tmp;
	}
}

public class ListTest {

	public static void main(String[] args) {
		
		int Array[]=new int[] {3,4,2,5,2,3,6,7,5,7,9};
		
		ArrayList<Integer> save=new CreateList().convertList(Array);
		for(Integer num : save) {
			System.out.println(num);
		}
		
		
	}

}
