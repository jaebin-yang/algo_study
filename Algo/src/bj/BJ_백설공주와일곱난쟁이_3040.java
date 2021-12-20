package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_백설공주와일곱난쟁이_3040 {

	static int S = 9, T = 7;
	static int[] src = new int[9];
	static int[] tgt = new int[7];
	static boolean done;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		for(int i = 0; i < 9; i ++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0);
		

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(done) return;
		// 기저조건
		if(tgtIdx == T) {
			// complete code
			int sum = 0;
			for(int i =0; i < T; i++) {
				sum += tgt[i];
			}
			
			if(sum == 100) {
				// 답
				done = true;
				for(int i = 0; i < T; i ++) {
					System.out.println(tgt[i]);
				}
			}
			return;
		}
		
		if(srcIdx == S) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
	}

}
