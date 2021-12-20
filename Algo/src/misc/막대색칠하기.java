package misc;

public class 막대색칠하기 {

	static int stickLength = 6;
	static int COUNT = 0;
	// 1cm 파랑 1cm 노랑 2cm 빨간
	public static void main(String[] args) {
		getComb(0);
		System.out.println(COUNT);

	}
	
	static public void getComb(int currLength) {
		if(currLength == stickLength) {
			COUNT ++; return;
		}
		if(currLength > stickLength) return;
		
		getComb(currLength+1);
		getComb(currLength+1);
		getComb(currLength+2);
	}

}
