package javaexam;

class Shape{
	String color="blue";
	void draw() {
		
	}
}

class Point{
	int x;
	int y;
	
	Point(){
		this(0,0);
	}
	
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class Circle extends Shape{
	Point center;
	int r;
	
	Circle(){
		this(new Point(0,0),100);
	}
	
	Circle(Point center,int r){
		this.center=center;
		this.r=r;
	}
	
}

class Triangle extends Shape{
	Point[] p;
	Triangle(Point[] p){
		this.p=p;
	}
	Triangle(Point p1,Point p2,Point p3){
		p=new Point[] {p1,p2,p3};
	}
}



public class Exercise3 {

	public static void main(String[] args) {
		
		Circle c1=new Circle();
		Circle c2=new Circle(new Point(150,150),50);
		
		Point p[]= {new Point(100,100),new Point(140,50),new Point(200,100)};
		
		
		Triangle t1=new Triangle(p);
		
		
	}
	
}
