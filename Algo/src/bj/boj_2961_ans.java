package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961_ans {
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		src = new int[N][2]; 
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			src[i][1] = Integer.parseInt(st.nextToken()); // 쓴마
		}
		
		comb(0, 1, 0);
		
		System.out.println(min);
	}
	
	static void comb( int srcIdx, int sinSum, int ssnSum) {
		// 기저조건
		if( srcIdx == N ) return;
		
		int currSin = src[srcIdx][0]*sinSum;
		int currSsn = src[srcIdx][1]+ssnSum;
		
		min = Math.min(min, Math.abs(currSin - currSsn));
		
		comb(srcIdx+1, currSin, currSsn);
		comb(srcIdx+1, sinSum, ssnSum);
	}
}
