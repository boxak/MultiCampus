package day8;

class SalaryExpr{
	int bonus;
	SalaryExpr(){
		bonus=0;
	}
	SalaryExpr(int bonus){
		this.bonus=bonus;
	}
	int getSalary(int grade) { //���⼭ bonus�� ��ȭ��Ű�� �� �ν��Ͻ��� ������ ����� ��쿡 ������ �� �� ����. 
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
		System.out.printf("%d �� %d ����� ������ %d �Դϴ�.%n", month,grade,money.getSalary(grade));
	}

}
