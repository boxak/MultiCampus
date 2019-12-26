package day15;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://movie.naver.com/");
		InputStream is = url.openStream(); //웹서버로의 요청이 일어나는 코드
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8")); //바이트 스트림
		//utf-8을 inputStreamReader 객체 생성할 때 입력해주면 한글이 깨지지 않는다.
		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
