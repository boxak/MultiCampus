package day12;

public class StringBufferTest {

	public static void main(String[] args) {		
		StringBuffer buffer = new StringBuffer();
		String str = "�ڹ����α׷���";
     		buffer.append(str);

        System.out.printf("%s\n", buffer);
        //buffer.reverse(); //buffer ��ü�� �յڷ� �ٲپ����.
        System.out.printf("%s\n", buffer); //�ڵ����� toString()�޼��带 ȣ���ؼ� ó��
        System.out.printf("���� : %d\n", buffer.length());   
        
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append('��');
        buffer2.append('��');
        buffer2.append('��');
        buffer2.append('��');
        buffer2.append('��');
        buffer2.append('��');
        buffer2.append('��');
        
        System.out.println(buffer==buffer2);
        System.out.println(buffer.equals(buffer2)); //bufferString���� equals�� ��� String���� ����ȯ�ؼ� ���ؾ���.
        System.out.println(buffer.toString().equals(buffer2.toString()));
        System.out.println(buffer.toString());
	}
}






