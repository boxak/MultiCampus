package day13;
import java.util.Date;
public class CreateGenericTest {
	public static void main(String[] args) {
		Value1 o1 = new Value1(); //Value1 : String�ۿ� ó������
		o1.put("abc");
		String s1 = o1.get(); 
		System.out.println(s1);		
		
		Value2 o2 = new Value2(); //� ��ü�� ���� ����
		o2.put("abc");
		String s2 = (String)o2.get(); //���� �� ����ȯ�� �ʼ�.
		System.out.println(s2);
		
		Value3<String> o3 = new Value3<>();	// java 8���ʹ� ������ �޼����� �����ȣ���� �� ��ȣ�� �־ �ȴ�.	
		o3.put("abc");
		String s3 = (String)o3.get(); //����ȯ ������ ���� �ȳ���.
		System.out.println(s3);	
		
		Value3<Date> o4 = new Value3<Date>();		
		o4.put(new Date()); //�����ߴ� �� �ǵ�����. -> Undo
		Date s4 = o4.get(); 
		System.out.println(s4);	
	}
}


class Value1 { //String ��ü�� ���� ����(String�� final Ŭ������)
	String obj;
	void put(String obj){
		this.obj = obj;
	}
	String get() {
		return obj;
	}
}
class Value2 { //String, StringBuffer, Book ��ü ���� ����.
	Object obj;
	void put(Object obj){
		this.obj = obj;
	}
	Object get() { //���� ���� ����ȯ ����� ��.
		return obj;
	}
}
// Value3<Card> v = new Value3<Card>();
// Value3<String> v = new Value3<String>();
// -> Card�� ���� ��ȣ �ȿ� ������ Value3���� Ŭ���� ���� �� TT�� Card�� �ٲ��.
// Ŭ������ ����� �ڷ� Ÿ���� ��ü ���� �ÿ� ���Ѵ�.

class Value3<TT> { //���� ��ȣ ���� ��Ī�� �ǹ̰� ����. element�� Ÿ���� �ǹ���.
	//Value3�� ��ü ���� �� <���� Ÿ��>���� ���׸��� ������ �ްڴٴ� �ǹ���.
	TT obj;
	void put(TT obj){
		this.obj = obj;
	}
	TT get() {
		return obj;
	}
}













