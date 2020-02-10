package vo;
public class QueryVO {
	private String testName;
	private int testAge;
	//testAge 에 값이 안와도 에러를 내지 않는다.
	private String testAddr;
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTestAge() {
		return testAge;
	}
	public void setTestAge(int testAge) {
		this.testAge = testAge;
	}
	public String getTestAddr() {
		return testAddr;
	}
	public void setTestAddr(String testAddr) {
		this.testAddr = testAddr;
	}	
}
