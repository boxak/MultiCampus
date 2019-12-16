package day7;

public class MemberTest {

	public static void main(String[] args) {
		Member a1 = new Member();
		Member a2 = new Member();
		Member a3 = new Member();
		a1.name = "황지원";
		a1.account = "boxak";
		a1.password = "1q2w3e4r";
		a1.birthyear = 1995;
		a2.name = "박은하";
		a2.account = "abcabc";
		a2.password = "qwerasdf";
		a2.birthyear = 1995;
		a3.name = "엄규영";
		a3.account = "ABC123";
		a3.password = "123123123";
		a3.birthyear = 1995;
		System.out.println("회원 1 : " + a1.name + '(' + a1.account + ',' + a1.password + ',' + a1.birthyear + ')');
		System.out.println("회원 2 : " + a2.name + '(' + a2.account + ',' + a2.password + ',' + a2.birthyear + ')');
		System.out.println("회원 3 : " + a3.name + '(' + a3.account + ',' + a3.password + ',' + a3.birthyear + ')');
	}

}
