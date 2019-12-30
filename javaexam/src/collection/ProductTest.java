package collection;
import java.util.*;
public class ProductTest {

	public static void main(String[] args) {
		
		Product p1=new Product("p100","TV","20000");
		Product p2=new Product("p200","Computer","10000");
		Product p3=new Product("p100","MP3","700");
		Product p4=new Product("p300","Audio","1000");
		HashSet <Product> productSet=new HashSet<>();
		
		Product productArr[]= {p1,p2,p3,p4};
		
		for(int i=0;i<productArr.length;i++) {
			if(productSet.add(productArr[i])) {
				System.out.println("���������� ����Ǿ����ϴ�.");
				continue;
			}
			System.out.println("������ ID�� ��ǰ�� �̹� ����Ǿ� �ֽ��ϴ�.");
		}
		System.out.println("��ǰID         ��ǰ��                        	����");
		Iterator <Product> iter=productSet.iterator();
		while(iter.hasNext()) {
			Product result=iter.next();
			System.out.printf("%-8s       %-8s        %-8s%n",result.getProductID(),result.getProductName(),result.getProductPrice());
		}
		
	}

}
