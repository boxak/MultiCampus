package day13;
import java.util.*;

public class LottoMachine2 {

	public static void main(String[] args) {
		
		HashSet <Integer> machine=new HashSet<Integer>();
		//Ÿ�Կ��� ���� Ŭ������ �־�� �Ѵ�.
		for(int i=0;i<10;i++) {
			while(true) {
				
				int inputNum=(int)(Math.random()*21)+10;
				if(machine.add(inputNum)) break;
			}
		}
		/*
		Iterator <Integer> iter=machine.iterator();
		System.out.printf("������ �ζǹ�ȣ : [%d", iter.next());
		while(iter.hasNext()) {
			int a=iter.next();
			System.out.printf(", %d", a);
		}
		System.out.println("]");
		*/
		System.out.println("������ �ζ� ��ȣ : "+machine);
	}

}
