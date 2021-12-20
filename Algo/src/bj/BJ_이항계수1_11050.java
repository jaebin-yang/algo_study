package bj;

import java.util.Scanner;

public class BJ_이항계수1_11050 {
	static int N, K;
	static int[] memoi;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int result = 0;
		if(N == 1 || K == 0 || N == K) result = 1;
		else if(N == 2) result = 2;
		else {
			// nCk = n! / ((n-k)!k!)
			memoi = new int[N+1];
			memoi[1] = 1;
			for(int i = 2; i <= N; i ++) {
				memoi[i] = i * memoi[i-1];
			}
			
			result = memoi[N] / (memoi[N-K] * memoi[K]);
		}
		
		System.out.println(result);
		
		
		
		
		
		sc.close();

	}

}
