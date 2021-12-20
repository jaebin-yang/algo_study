package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_RGB거리_1249 {
	
	static int N;
	static int[][] memoi; // i 까지 누적 색칠 비용
	static int[][] cost; // i 번째 색칠 비용
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // R
			cost[i][1] = Integer.parseInt(st.nextToken()); // G
			cost[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		
		memoi = new int[N+1][3];
		// 시작항 (초기값 설정)
		memoi[1][0] = cost[1][0];
		memoi[1][1] = cost[1][1];
		memoi[1][2] = cost[1][2];
		
		for (int i = 2; i <= N; i++) {
			memoi[i][0] = Math.min(memoi[i-1][1], memoi[i-1][2]) + cost[i][0];
			memoi[i][1] = Math.min(memoi[i-1][0], memoi[i-1][2]) + cost[i][1];
			memoi[i][2] = Math.min(memoi[i-1][0], memoi[i-1][1]) + cost[i][2];
		}
		
		System.out.println(   Math.min( Math.min(memoi[N][0], memoi[N][1]), memoi[N][2])  );
	}

}









