package day12;
public class StringTest {
	public static void main(String[] args) {
		System.out.println("1".length());    				
		System.out.println("������".length()); 					
		System.out.println("abc".charAt(1)); //charAt�� ���ڿ��� ���° �ε����� ���ڸ� �����Ѵ�.			
		System.out.println("abc".toUpperCase());	 	
		String str1 = "ABCDEFGHIJ";
		String str2 = "abcdefgfhij";
		
		System.out.println(str1.substring(4)); //4��° ���ں��� ������ ���ڱ��� ��ȯ        
		System.out.println(str1.substring(0, 3)); //�����ε��� ������ ��� ��ȯ
		System.out.println(str2.indexOf("f")); //f�� �ε��� ��ȯ
		System.out.println(str2.lastIndexOf("f")); //������ f�� �ε��� ��ȯ
		System.out.println(str2.replace('h', 'H')); //���ο� ��Ʈ�� ��ü�� ���� h�� H�� ���� ��ȯ
		
		String str3 = "java:html5:css3:javascript";
		String[] ary = str3.split(":"); // : �� �������� ���ڿ��� �����ؼ� String�迭�� ��ȯ����.
		
		for(int i=0; i < ary.length; i++){
			System.out.println(ary[i]);
		}		
		char ch[] = str3.toCharArray(); //�־��� ���ڿ��� �ѱ��ھ� �ɰ��� char �� �迭�� ��´�. 
		System.out.println(str3.length() + " ---- " + ch.length);
		System.out.println(ch);
		for(int i=0; i < ch.length; i++){
			System.out.print(ch[i]);
		}
	}
}













