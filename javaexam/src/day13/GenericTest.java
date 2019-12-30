package day13;
import java.util.*;
public class GenericTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(); //Ŭ���� �̸��� ���谡 �����Ƿ� Generics ������.
		//Generics ������ ���� � Ÿ���� �ڷḦ ���� ������ �˷���� ��. �ڵ����� Object���� ��� ������ ������.
		// -> Ÿ�� �Ķ����
		list.add("java");
		list.add("100");
		list.add("servlet");
		list.add("jdbc");
		
		for(int i=0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();		
		
		for(Object value : list) {
			String s = (String)value;		
			System.out.println(s);
		}
		System.out.println();		
		
		Iterator iter = list.iterator(); //Iterator : �������̽�
		while(iter.hasNext()){
			Object value = iter.next();
			String s = (String)value;		
			System.out.println(s);
		}
	}
}
