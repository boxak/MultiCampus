package vo;

public class CalcVO {
	int num1;
	int num2;
	int result;
	String operator;
	String errorMsg;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
	public int getResult() {
		return result;
	}
	public String getOperator() {
		return operator;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
