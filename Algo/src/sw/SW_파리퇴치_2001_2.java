package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_파리퇴치_2001_2 {

	static int[][] map;
	static int T, N, M, max ;
	static int[] colSum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			colSum = new int[N];
			for(int i = 0; i < N; i ++) {
				st =  new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			for(int i = 0; i < N - M + 1; i ++) {
				// 매번 열 배얼 계산
				// j ->N-1
				for(int j = 0; j < N-M+1; j ++) {
					colSum[j] = 0;
					for(int k = 0; k < i + M; k ++ ) {
							// 아래로 움지ㄱ여보면서
						colSum[j] += map[k][j];
						
					}
				}
				
				for(int j = 0; j < N - M + 1; j ++) {
					int temp = 0;
					for(int k =j ; k < j + M; k ++) {
						temp += colSum[k]
;					}
					
					max = Math.max(max, temp);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}

	}
	
	static int flyCount(int y, int x) {
		int count = 0;
		for(int i = y; i < y + M ; i ++) {
			for(int j = x; j < x + M; j ++) {
				count += map[i][j];
			}
		}
		return count;
		
		
	}

}
