package day2;

public class ConditionOperLab {

	public static void main(String[] args) {
		int det=(int)(Math.random()*5)+1;
		int result=0;
		if(det==1) {
			result=300+50;
		}
		else if(det==2) {
			result=300-50;
		}
		else if(det==3) {
			result=300*50;
		}
		else if(det==4) {
			result=300/50;
		}
		else if(det==5) {
			result=300%50;
		}
		System.out.print(result);

	}

}
