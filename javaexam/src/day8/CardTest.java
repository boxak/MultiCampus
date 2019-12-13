package day8;

public class CardTest{
	public static void main(String args[]) throws Exception{	
		
		System.out.println("Card_width = "+Card.width);
		System.out.println("Card_height = "+Card.height);
		
		Card c1 = new Card();
		c1.kind="Heart";
		c1.number=7;
		
		Card c2=new Card();
		c2.kind="Spade";
		c2.number=4;
		
		System.out.printf("c1 : %s, %d, %d, %d%n",c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2 : %s, %d, %d, %d%n",c2.kind,c2.number,c2.width,c2.height);
		
		
		Card.width=50;
		Card.height=80;
		
		System.out.printf("c1 : %s, %d, %d, %d%n",c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2 : %s, %d, %d, %d%n",c2.kind,c2.number,c2.width,c2.height);
		
		
	}
}




