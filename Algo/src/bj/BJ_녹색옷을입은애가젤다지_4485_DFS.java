package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_녹색옷을입은애가젤다지_4485_DFS {
	static int N, min;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int callCnt; // debug
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			visit = new boolean[N][N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작점 0, 0
			visit[0][0] = true;
			callCnt = 0;
			dfs(0, 0, map[0][0]); // y, x, 비용 (누적 비용: 이 곳까지 오는 비용)
			
			System.out.println("Problem " + t + ": " + min);
			System.out.println("callCnt " + t + " " + callCnt);
			
			t++;
			
			
		}

	}
	static void dfs(int y, int x, int c) {
		callCnt++;
		// 기저조건
		if(y == N-1 && x == N-1) {
			min = Math.min(min, c);
			return;
		}
		
		// 탐색
		for(int i = 0; i < 4; i ++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx <0 || ny>=N || nx >=N || visit[ny][nx]) continue;
			
			// 가지치기
			if(c+map[ny][nx] >= min ) continue;
			
			visit[ny][nx] = true;
			dfs(ny, nx, c + map[ny][nx]);
			visit[ny][nx] = false;
		}
	}

}
