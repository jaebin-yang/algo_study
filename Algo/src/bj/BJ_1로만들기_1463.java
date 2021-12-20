package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1로만들기_1463 {
	static int N;
	static int min;
	static int []memoi;
	public static void main(String[] args) throws Exception {
		// X가 3으로 나누어 떨어지면, 3으로 나눈다
		// X가 2로 나누어 떨어지면 2로 나눈다
		// 1을 뺀다
		
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;

		
		memoi = new int[N+1];
		memoi[1] = 0;
//		memoi[2] = 1;
//		memoi[3] = 1;
		for(int i = 2; i <= N; i ++) {
			int min = Integer.MAX_VALUE;
			memoi[i] = memoi[i-1]+1;
			if(i%2 == 0 && memoi[i] > memoi[i/2]+1) memoi[i] = memoi[i/2]+1;
			if(i%3 == 0 && memoi[i] > memoi[i/3]+1) memoi[i] = memoi[i/3]+1;

		}
		

		System.out.println(memoi[N]);


		
	}

}
