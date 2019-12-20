package javaexam;
import java.util.*;
public class exerciseLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Character> stack=new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char Array[]=new char[1000];
		int len=s.length();
		for(int i=0;i<len;i++) {
			Array[i]=s.charAt(i);
		}
		boolean flag=true;
		for(int i=0;i<len;i++) {
			if(Array[i]=='(') {
				stack.addLast('(');
			}
			else {
				if(stack.isEmpty()==false) {
					stack.removeLast();
				}
				else {
					flag=false;
					break;
				}
			}
		}
		if(flag==false) System.out.println("False!");
		else System.out.println("Right!");
	}

}
