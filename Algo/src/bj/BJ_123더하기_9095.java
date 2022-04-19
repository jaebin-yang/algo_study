package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_123더하기_9095 {
	static int T;
	static int[] memoi;
	static int[] index;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		memoi = new int[11];
		index = new int[T];
		for(int i = 0; i < T; i ++) {
			index[i] = Integer.parseInt(br.readLine());
		}
		memoi[1] = 1; // 1밖에 없다.
		memoi[2] = 2; // 1+1, 2;
		memoi[3] = 4; // 1+1+1, 1+2, 2+1, 3
		for(int i = 4; i < 11; i ++) {
			memoi[i] = memoi[i-1] + memoi[i-2] + memoi[i-3];
		}
		
		for(int i = 0; i < T; i ++) {
			System.out.println(memoi[index[i]]);
		}
		


	}

}
