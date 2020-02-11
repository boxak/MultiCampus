package day8;

class SalaryExpr{
	int bonus;
	SalaryExpr(){
		bonus=0;
	}
	SalaryExpr(int bonus){
		this.bonus=bonus;
	}
	int getSalary(int grade) { //여기서 bonus를 변화시키면 이 인스턴스를 여러번 사용할 경우에 문제가 될 수 있음. 
		return bonus-(grade-1)*10+100;
	}
}

public class SalaryExam {

	public static void main(String[] args) {
		int month=day6.MethodLab3.getRandom(12);
		int grade=day6.MethodLab3.getRandom(4);
		SalaryExpr money;
		if(month%2==0) money=new SalaryExpr(100);
		else money=new SalaryExpr();
		System.out.printf("%d 월 %d 등급의 월급은 %d 입니다.%n", month,grade,money.getSalary(grade));
	}

}
