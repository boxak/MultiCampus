package day12;
public class StringTest {
	public static void main(String[] args) {
		System.out.println("1".length());    				
		System.out.println("가나다".length()); 					
		System.out.println("abc".charAt(1)); //charAt은 문자열의 몇번째 인덱스의 글자를 리턴한다.			
		System.out.println("abc".toUpperCase());	 	
		String str1 = "ABCDEFGHIJ";
		String str2 = "abcdefgfhij";
		
		System.out.println(str1.substring(4)); //4번째 글자부터 마지막 글자까지 반환        
		System.out.println(str1.substring(0, 3)); //엔드인덱스 제외한 결과 반환
		System.out.println(str2.indexOf("f")); //f의 인덱스 반환
		System.out.println(str2.lastIndexOf("f")); //마지막 f의 인덱스 반환
		System.out.println(str2.replace('h', 'H')); //새로운 스트링 객체를 만들어서 h를 H로 만들어서 반환
		
		String str3 = "java:html5:css3:javascript";
		String[] ary = str3.split(":"); // : 을 기준으로 문자열을 구분해서 String배열로 반환해줌.
		
		for(int i=0; i < ary.length; i++){
			System.out.println(ary[i]);
		}		
		char ch[] = str3.toCharArray(); //주어진 문자열을 한글자씩 쪼개서 char 형 배열에 담는다. 
		System.out.println(str3.length() + " ---- " + ch.length);
		System.out.println(ch);
		for(int i=0; i < ch.length; i++){
			System.out.print(ch[i]);
		}
	}
}













