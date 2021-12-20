package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_동철이의일분배_1865 {

	static int T, N;
	static int[][] jobs;
	static boolean[] jobTaken;
	
	static double total;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			
			jobs = new int[N][N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					jobs[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//System.out.println(Arrays.deepToString(jobs));
			jobTaken = new boolean[N];
			
			total = Integer.MIN_VALUE;
			// dfs 
			dfs(0, 1.0);
			
		//	double result = Math.round(total * 10000000 * 100) / 10000000.0;
			String answer = String.format("%.6f", total * 100);
			System.out.println("#" + t + " " + answer);
//			double a = 25.565;
//			System.out.println(a / 100.0);
			
		}
		

	}
	
	static void dfs(int n, double chance) {
		if(chance <= total) return;
		if(n == N) {
			if(total < chance) total = chance;
			return;
		}
		for(int i = 0; i < N; i ++) {
			if(!jobTaken[i]) {
				jobTaken[i] = true;
				double curr = chance * (jobs[n][i] / 100.0);
				dfs(n+1, curr);
				jobTaken[i] = false;
			}
		}
	}

}
