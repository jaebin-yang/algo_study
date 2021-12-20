package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_준환이의양팔저울_3234_2 {

	static int T, N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			int[]choo = new int[N];
			boolean[]select = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i > N; i ++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			perm(choo, select, 0,0,0); 
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// index : 0, 왼쪽 합, 오른쪽 합 매 단계에서 계산해서 다음 재귀호출에 전달
	static void perm(int[] choo, boolean[] select, int tgtIdx, int leftSum, int rightSum) {
		// 가지치기
		if(rightSum > leftSum) return;
		
		if(tgtIdx == N) {
			ans ++;
			return;
		}
		
		for(int i = 0; i < N; i ++) {
			if(select[i]) continue;
			select[i] = true;
			perm(choo, select, tgtIdx+1, leftSum + choo[i], rightSum);
			perm(choo, select, tgtIdx+1, leftSum, rightSum + choo[i]);
			select[i] = false;
		}
	}

}
