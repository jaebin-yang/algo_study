package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485_dfs {

	static int N, count, min;
	static int[][] cave;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 1;
	
		while(N != 0) {
			min = Integer.MAX_VALUE;
			cave = new int[N][N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// dfs? -> 시간초과 | 다익스트라?
			//(0,0)에서 출발, (N-1, N-1)도착
			visited = new boolean[N][N];
			dfs(0, 0, 0);
			
			
			System.out.println("Problem " + count + ": " + min);
			count ++;
			N = Integer.parseInt(br.readLine());
		}
	}
	
	static void dfs(int y, int x, int cost) {
		if(y == N-1 && x == N-1) {
			cost += cave[N-1][N-1];
			if(cost < min) min = cost;
			return;
		}
		if(cost + cave[y][x] > min) return;
		visited[y][x] = true;
		for(int i = 0; i < 4; i ++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty < 0 || ty >= N || tx < 0 || tx >= N) continue;
			if(visited[ty][tx]) continue;
			dfs(ty, tx, cost + cave[y][x]);
		}
		
		visited[y][x] = false;
	}
	

}
