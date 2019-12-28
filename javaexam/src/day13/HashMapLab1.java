package day13;
import java.util.*;
public class HashMapLab1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		HashMap<String,Integer> contries=new HashMap<String,Integer>();
		//argument를 안주면 16개 버킷이 생성된다.
		String contryName="";
		int population=0;
		while(contries.size()<5) {
			System.out.print("나라이름을 입력하세요 : ");
			contryName=sc.next();
			System.out.print("인구 수를 입력하세요 : ");
			population=sc.nextInt();
			if(contries.get(contryName)==null) {
				contries.put(contryName,population);
				System.out.println("저장되었습니다.");
			}
			else {
				System.out.println("나라명 "+contryName+" 이미 저장되었습니다.");
			}
		}
		System.out.println("5개가 모두 입력되었습니다.");
		System.out.print("입력된 데이터 : ");
		//Set <String> keys=contries.keySet();
		Iterator <String> iter=contries.keySet().iterator(); //contries.keySet().iterator(); 로 한번에 해줘도 된다.
		
		contryName=iter.next();
		System.out.printf("%s(%d)",contryName,contries.get(contryName));
		while(iter.hasNext()) {
			contryName=iter.next();
			System.out.printf(", %s(%d)",contryName,contries.get(contryName));
		}
		
		/*
		 	while(true){
		 		key=iter.next();
		 		value=contries.get(key);
		 		System.out.printf("%s(%d)",key,value);
		 		if(iter.hasNext()) System.out.print(",");
		 		else break;
		 	}
		 */
		
		sc.close();
	}

}
