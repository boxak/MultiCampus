package day14;

import java.io.*;
public class FileReaderTest {
    public static void main(String args[]) {
       FileReader reader = null;
       try {
           reader = new FileReader("c:/iotest/today.txt");
           while (true) {
               int data = reader.read();
               if (data == -1)
                   break;
               char ch = (char) data;
               System.out.print(ch);
           }
       } catch (FileNotFoundException fnfe) {
           System.out.println("파일이 존재하지 않습니다.");
       } catch (IOException ioe) {
           System.out.println("파일을 읽을 수 없습니다.");
       } finally {
          try {
        	  if(reader!=null) {
        		  reader.close(); //reader가 생성되지 않았으면 close도 할수가 없다.
        	  }
          } catch (Exception e) {
        	  e.printStackTrace();
          }
       }
    }
}




