package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Magnetic_1220 {
	static int [][] table;
	static int N;
	static int prev, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10 ; t ++) {
			N = Integer.parseInt(br.readLine());
			// 테이블 위: N극, 테이블 아래: S극
			table = new int[N][N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			
			for(int j = 0; j < N; j ++) {
				prev = 0;
				for(int i = 0; i < N; i ++) {
					if(table[i][j] == 2) { // S극
						if(prev == 1) {
							count ++;
							
						}
						prev = 2;
					}
					else if(table[i][j]==1) prev = 1; // N극
				}
			}
			
			System.out.println("#" + t + " " + count);
			
		}

	}

}
