package bj;

import java.util.Scanner;

public class BJ_파도반수열_9461 {

	static int T, N;
	static long[] memoi;
	static long result;
	public static void main(String[] args) {
		// 3 까진 1 1 1 
		// 그 다음부턴 i-2 + i-3
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t ++) {
			N = sc.nextInt();
			if(N <= 3) {
				result = 1;
			}
			else {
				memoi = new long[N+1];
				memoi[1] = 1;
				memoi[2] = 1;
				memoi[3] = 1;

				
				for(int i = 4; i <= N; i ++) {
					memoi[i] = memoi[i-2] + memoi[i-3];
				}
				result = memoi[N];
				
			}
			System.out.println(result);
		}
		
		
		sc.close();

	}

}
