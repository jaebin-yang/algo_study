package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_주사위던지기1_1169 {
	static int N, M;
	static int[] comb;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		comb = new int[N];
		visited = new boolean[7];
		switch(M) {
		case 1:
			comb(0); break;
		case 2:
			subset(0); break;
		case 3:
			perm(0); break;
		}
	}
	
	static void subset(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i ++) {
				System.out.print(comb[i] + " ");
			}
			System.out.println();
			return;
		}

		if(cnt == 0) {
			for(int i = 1; i <= 6; i ++) {
				comb[cnt] = i;
				subset(cnt + 1);
			}
		}
		else {
			for(int i = comb[cnt-1]; i <= 6; i ++) {
				comb[cnt] = i;
				subset(cnt + 1);
			}
		}

	}
	static void comb(int curr) {
		if(curr == N) {
			for(int i = 0; i < N; i ++) {
				System.out.print(comb[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= 6; i ++) {
			comb[curr] = i;
			comb(curr + 1);
		}
		
	}
	
	static void perm(int curr) {
		if(curr == N) {
			for(int i = 0; i < N; i ++) {
				System.out.print(comb[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= 6; i ++) {
			if(!visited[i]) {
				comb[curr] = i;
				visited[i] = true;
				perm(curr+1);
				visited[i] = false;
				
			}
		}
	}

}
