package javaexam;

class CaptionTv extends Tv{
	String text;
	void caption() {}
}

public class TvTest {

	public static void main(String[] args) {
		
		//Tv t=new Tv();
		//CaptionTv c1=new CaptionTv();
		
		CaptionTv c1 = new CaptionTv();
		Tv t=new CaptionTv();
		//CaptionTv c=new Tv(); -> ������ ����!
		t.power=false;
		t.channel=0;
		c1.text="KBS Studio";
		//System.out.println(t.text); -> t ��ü�� text�� �� �� ����.
		System.out.printf("%b%n", t.power);
		t.power();
		System.out.printf("%b%n", t.power);
	}

}
