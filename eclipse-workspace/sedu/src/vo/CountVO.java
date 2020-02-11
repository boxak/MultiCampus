package vo;
// xxxVO - Value Object - 값을 보관하는 용도의 객체
// xxxDAO - Data Access Object - DB 연동기능(JDBC)을 지원하는 객체
// xxxService(xxxBiz) - Service Object - 이런저런 서비스 로직을 지원하는 객체
public class CountVO {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number += number;
	}	
}
