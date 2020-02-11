package day13;
import java.util.*;
public class GenericTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(); //클래스 이름에 꺾쇠가 있으므로 Generics 구문임.
		//Generics 구문을 통해 어떤 타입의 자료를 담을 것인지 알려줘야 함. 자동으로 Object형을 담는 것으로 결정함.
		// -> 타입 파라미터
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
		
		Iterator iter = list.iterator(); //Iterator : 인터페이스
		while(iter.hasNext()){
			Object value = iter.next();
			String s = (String)value;		
			System.out.println(s);
		}
	}
}
