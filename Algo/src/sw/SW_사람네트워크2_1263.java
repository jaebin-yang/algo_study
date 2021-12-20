package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_사람네트워크2_1263 {

	static int T, N;
	static int[][] CC;
	static int max = 9999999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			CC = new int[N][N];
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 0 && i != j) CC[i][j] = max;
					else CC[i][j] = temp;
				}
			}


			// user Floyd-Warshall to get shortest path

			for(int k = 0; k < N; k ++) {
				for(int i = 0; i < N; i ++) {
					if(i != k) {
						for(int j = 0; j < N; j ++) {
							if(j!= k && j!= i) {
								CC[i][j] = Math.min(CC[i][k] + CC[k][j], CC[i][j]);
							}
						}
					}
				}
			}
			
			int result = Integer.MAX_VALUE;
			for(int i = 0; i < N; i ++) {
				int temp = getRowSum(i);
				if(result > temp) result = temp;
			}
			
			System.out.println("#" + t + " " + result);
			
			

		}

	}
	
	static int getRowSum(int idx) {
		int sum = 0;
		for(int i = 0; i < N; i ++) {
			sum += CC[idx][i];
		}
		return sum;
	}

}
