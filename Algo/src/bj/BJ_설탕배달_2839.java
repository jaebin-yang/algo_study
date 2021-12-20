package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_설탕배달_2839 {
	static int N, fiveCount, threeCount, totalCount;
	// 3kg, 5kg
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());

		fiveCount = N / 5;
		while(fiveCount > 0) {
			int remainder = N - 5  * fiveCount;
			if(remainder % 3 == 0) {
				threeCount = remainder / 3;
				break;
			}
			fiveCount --;
		}
		if(fiveCount == 0) {
			if(N % 3 != 0) {
				threeCount = -1;
			} else {
				threeCount = N / 3;
			}
		}
		totalCount = fiveCount + threeCount;

		System.out.println(totalCount);
	}

}
