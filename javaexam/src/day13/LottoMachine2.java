package day13;
import java.util.*;

public class LottoMachine2 {

	public static void main(String[] args) {
		
		HashSet <Integer> machine=new HashSet<Integer>();
		//타입에는 래퍼 클래스를 넣어야 한다.
		for(int i=0;i<10;i++) {
			while(true) {
				
				int inputNum=(int)(Math.random()*21)+10;
				if(machine.add(inputNum)) break;
			}
		}
		/*
		Iterator <Integer> iter=machine.iterator();
		System.out.printf("오늘의 로또번호 : [%d", iter.next());
		while(iter.hasNext()) {
			int a=iter.next();
			System.out.printf(", %d", a);
		}
		System.out.println("]");
		*/
		System.out.println("오늘의 로또 번호 : "+machine);
	}

}
