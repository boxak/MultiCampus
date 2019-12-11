package day7;

class Time{
	int hour;
	int minute;
	float second;
	
	int getHour() {
		return hour;
	}
	int getMinute() {
		return minute;
	}
	float getSecond() {
		return second;
	}
	void setHour(int h) {
		if(h<0 || h>23) return;
		hour=h;
	}
	void setMinute(int m) {
		if(m<0 || m>59) return;
		minute=m;
	}
	void setSecond(float s) {
		if(s<0.0f ||s>59.99f) return;
		second=s;
	}
}

public class TimeTest {

	public static void main(String[] args) {
		Time t1=new Time();
		Time t2=new Time();
		Time diff=new Time();
		t1.setHour(1);
		t1.setMinute(41);
		t1.setSecond(4.00f);
		t2.setHour(1);
		t2.setMinute(24);
		t2.setSecond(11.00f);
		diff=getDiff(t1,t2);
		System.out.printf("(%d 시, %d 분, %.2f 초)%n", diff.hour,diff.minute,diff.second);
	}
	
	static Time getDiff(Time t1,Time t2) {
		Time big=new Time();
		Time small=new Time(); //먼저 누구의 시간이 더 큰지 정함
		Time diff=new Time();
		if(t1.getHour()==t2.getHour()) { //시가 같을 경우
			if(t1.getMinute()==t2.getMinute()) { //분이 같을 경우
				if(t1.getSecond()==t2.getSecond()) { //초가 같을 경우
					diff.hour=0;diff.minute=0;diff.second=0;
					return diff; //0을 리턴
				}
				else if(t1.getSecond()>t2.getSecond()) { //t1의 초가 t2보다 클 경우
					big=t1;small=t2;
				}
				else { //t2의 초가 t1보다 클 경우
					big=t2;small=t1;
				}
			}
			else if(t1.getMinute()>t2.getMinute()) { //t1의 분이 t2보다 클 경우
				big=t1;small=t2;
			}
			else { //t2의 분이 t1보다 클 경우
				big=t2;small=t1;
			}
		}
		else if(t1.getHour()>t2.getHour()) { //t1의 시가 t2보다 클 경우
			big=t1;small=t2;
		}
		else { //t2의 시가 t1보다 클 경우 
			big=t2;small=t1;
		}
		if(big.getSecond()>=small.getSecond()) {
			diff.second=big.getSecond()-small.getSecond();
		}
		else {
			diff.second=big.getSecond()+60-small.getSecond();
			if(big.getMinute()>0) {
				big.minute--;
			}
			else {
				big.minute=59;
			}
		}
		if(big.getMinute()>=small.getMinute()) {
			diff.minute=big.getMinute()-small.getMinute();
		}
		else {
			diff.minute=big.getMinute()+60-small.getMinute();
			big.hour--;
		}
		diff.hour=big.hour-small.hour;
		return diff;
	}

}
