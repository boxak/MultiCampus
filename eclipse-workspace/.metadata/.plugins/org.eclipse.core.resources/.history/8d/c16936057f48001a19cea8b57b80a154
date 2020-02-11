package sample1;

public class MessageBeanImpl2 implements MessageBean2 {
	private String fruit;
	private int cost;	
	public MessageBeanImpl2() {
		super(); //조상의 생성자 호출
		System.out.println("MessageBeanImpl Default Constructor Call");
	}
	public MessageBeanImpl2(String fruit) {
		super();
		this.fruit = fruit;
		System.out.println(fruit + " :  MessageBeanImpl Constructor Call");
	}

	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost() Call");
	}

	@Override
	public void sayHello() {      
		System.out.println(fruit + "   " + cost); // 멤버 변수 fruit, cost
	}

	@Override                     
	public void sayHello(String fruit, int cost) {   
		System.out.println(fruit + "   " + cost); // 매개 변수 fruit, cost
	}
}
