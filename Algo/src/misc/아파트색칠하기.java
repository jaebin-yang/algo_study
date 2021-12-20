package misc;

public class 아파트색칠하기 {

	static int COUNT = 0;
	static int currColor = -1; // 0 : yellow, 1 : blue
	static int N = 8;
	public static void main(String[] args) {
		// 노란색 인접 두 층 연속 ㅇ
		// 파란색 인접 두 층 연속 ㄴ
		// 노랑 2 노랑 1 파랑 1
		aptColor(0);
		System.out.println(COUNT);

		
		

	}
	
	public static void aptColor(int idx) {
		if(idx == 8) {
			COUNT ++; return;
		}
		else if(idx > 8) {
			return;
		}
		if(currColor == 1) {
			aptColor(idx + 2);
			aptColor(idx + 1);
			currColor = 0;
		}
		else if(currColor == -1) { // 시작 전
			aptColor(idx+2);
			aptColor(idx + 1);
			currColor = 0;
			aptColor(idx + 1);
			currColor = 1;
		}
		else {
			aptColor(idx + 1);
			currColor = 1;
		}
	}
}
