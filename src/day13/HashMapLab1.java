package day13;
import java.util.*;
public class HashMapLab1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		HashMap<String,Integer> contries=new HashMap<String,Integer>();
		//argument�� ���ָ� 16�� ��Ŷ�� �����ȴ�.
		String contryName="";
		int population=0;
		while(contries.size()<5) {
			System.out.print("�����̸��� �Է��ϼ��� : ");
			contryName=sc.next();
			System.out.print("�α� ���� �Է��ϼ��� : ");
			population=sc.nextInt();
			if(contries.get(contryName)==null) {
				contries.put(contryName,population);
				System.out.println("����Ǿ����ϴ�.");
			}
			else {
				System.out.println("����� "+contryName+" �̹� ����Ǿ����ϴ�.");
			}
		}
		System.out.println("5���� ��� �ԷµǾ����ϴ�.");
		System.out.print("�Էµ� ������ : ");
		//Set <String> keys=contries.keySet();
		Iterator <String> iter=contries.keySet().iterator(); //contries.keySet().iterator(); �� �ѹ��� ���൵ �ȴ�.
		
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
