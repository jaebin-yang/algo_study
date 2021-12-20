package bj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_설탕배달_2839_DP {

	static int N;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 초기 값(배열 생성) 정리
		if( N <= 5 ) {
			if( N==3 || N==5 ) System.out.println(1);
			else System.out.println(-1);
			sc.close();
			return;
		}
		
		dp = new int[N+1];
		Arrays.fill(dp, 5000);
		
		dp[3] = 1; // 3kg 은 1개 봉투를 쓰면 된다.
		dp[5] = 1; // 5kg 은 1개 봉투를 쓰면 된다.
		
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
		}
		
		if( dp[N] > 5000 ) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N]);
		}
		sc.close();
	}
}
