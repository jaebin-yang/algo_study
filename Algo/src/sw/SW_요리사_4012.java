package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_요리사_4012 {

	static int T, N;
	static boolean[] select;
	static int [][] synergy;
	static int minSyn;
	static int [] food1, food2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t < T; t ++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			select = new boolean[N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int[] food1 = new int[N/2];
			int[] food2 = new int[N/2]; 
			
			
			minSyn = Integer.MAX_VALUE;
			
			
			
		}
	}
	
	static void  comb(int count, int idx) {
		if(count == N/2) {
			int one = 0; int two = 0;
			for(int i = 0; i < N; i ++) {
				if(select[i]) {
					food1[one] = i;
					one ++;
				} else {
					food2[two] = i;
					two ++;
				}
			}
			int syn = Math.abs(calculateSynergy(food1, 0, 0) - calculateSynergy(food2, 0, 0));
			if(minSyn > syn) {
				minSyn = syn;
			}
			return;
		}
		
		select[idx] = true;
		comb(count+1, idx+1);
		select[idx] = false;
		comb(count, idx+1);
	}
	
	static int calculateSynergy(int [] food, int srcIdx, int tgtIdx) {
		int syn = 0;
		return syn;

	}

}
