package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInputTest{

	public static void main(String[] args) throws Exception{
		System.out.print("입력 : ");
		//int input=new InputStreamReader(System.in).read();
		//System.out.println((char)input);
		String input=new BufferedReader(new InputStreamReader(System.in)).readLine(); //String으로 받는다.
		System.out.println("출력 : "+input);
		
		
	}

}
