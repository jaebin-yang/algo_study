package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_준환이의양팔저울_3234 {
	static int T, N, count;
	static int[] weights;
	static boolean[] select;
	static int totalWeight;
	static int[] tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			select = new boolean[N];
			tgt = new int[N];
			count = 0;
			totalWeight = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i ++) {
				int weight = Integer.parseInt(st.nextToken());
				weights[i] = weight;
				totalWeight += weight;
			}
			
			perm(0);
			
			System.out.println("#" + t + " " + count);
			
		}
	
				
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == N) {
			subset(0, 0, 0);
		}
		for(int i = 0; i < N; i ++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = weights[i];
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;
		}
	}
	
	static void subset(int srcIdx, int weightLeft, int weightRight) {
		

		// 기저조건
		if(srcIdx == N) {
			count ++;
			return;
		}
		
		// 오른쪽 무게의 총합이 왼쪽 무게보다 커지지 않게
		if(weightRight + tgt[srcIdx] <= weightLeft) {
			subset(srcIdx+1, weightLeft, weightRight + tgt[srcIdx]);
		}
		subset(srcIdx+1, weightLeft + tgt[srcIdx], weightRight);
		
		
	}

}
