package day13;
import java.util.Date;
public class CreateGenericTest {
	public static void main(String[] args) {
		Value1 o1 = new Value1(); //Value1 : String밖에 처리못함
		o1.put("abc");
		String s1 = o1.get(); 
		System.out.println(s1);		
		
		Value2 o2 = new Value2(); //어떤 객체든 저장 가능
		o2.put("abc");
		String s2 = (String)o2.get(); //꺼낼 때 형변환이 필수.
		System.out.println(s2);
		
		Value3<String> o3 = new Value3<>();	// java 8부터는 생성자 메서드의 꺾쇠괄호에는 빈 괄호만 넣어도 된다.	
		o3.put("abc");
		String s3 = (String)o3.get(); //형변환 지워도 에러 안난다.
		System.out.println(s3);	
		
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date()); //편집했던 걸 되돌린다. -> Undo
		Date s4 = o4.get(); 
		System.out.println(s4);	
	}
}


class Value1 { //String 객체만 저장 가능(String은 final 클래스임)
	String obj;
	void put(String obj){
		this.obj = obj;
	}
	String get() {
		return obj;
	}
}
class Value2 { //String, StringBuffer, Book 객체 저장 가능.
	Object obj;
	void put(Object obj){
		this.obj = obj;
	}
	Object get() { //꺼낼 때는 형변환 해줘야 함.
		return obj;
	}
}
// Value3<Card> v = new Value3<Card>();
// Value3<String> v = new Value3<String>();
// -> Card를 꺽쇠 괄호 안에 넣으면 Value3에서 클래스 생성 시 TT가 Card로 바뀐다.
// 클래스에 저장될 자료 타입을 객체 생성 시에 정한다.

class Value3<TT> { //꺾쇠 괄호 안의 명칭은 의미가 없다. element의 타입을 의미함.
	//Value3는 객체 생성 시 <변수 타입>으로 제네릭스 구문을 받겠다는 의미임.
	TT obj;
	void put(TT obj){
		this.obj = obj;
	}
	TT get() {
		return obj;
	}
}













