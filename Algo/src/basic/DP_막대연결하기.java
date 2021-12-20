package basic;

import java.util.Arrays;

public class DP_막대연결하기 {
	static int memoi[] = new int[11]; // 0 dummy
	public static void main(String[] args) {
		memoi[1] = 2;
		memoi[2] = 5;
		
		for(int i = 3;i <= 10; i ++) {
			memoi[i] = memoi[i-1] * 2 + memoi[i-2];
		}
		
		System.out.println(Arrays.toString(memoi));

	}

}
