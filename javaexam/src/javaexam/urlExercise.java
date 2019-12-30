package javaexam;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
public class urlExercise {

	public static void main(String[] args) throws Exception{
		try {
			URL url=new URL("https://i.ytimg.com/vi/YaVZH20o7Ds/hqdefault.jpg");
			InputStream is=url.openStream();
			FileOutputStream fos=new FileOutputStream("c:/iotest/bad_guy.jpg");
			int input=0;
			while(true) {
				input=is.read();
				if(input==-1) {
					break;
				}
				fos.write(input);
			}
			fos.close();
			System.out.println("���������� ����");
		}catch(MalformedURLException e) {
			System.out.println("URL���ڿ� ���� : "+e.getMessage());
		}catch(IOException e) {
			System.out.println("IO ���� : "+e.getMessage());
		}
		
		
	}

}
