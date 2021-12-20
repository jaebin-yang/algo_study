package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_연구소_14502 {
	// 완탐 방식
	// 벽 3개를 세우는 모든 경우 조합
	// 위 모든 경우에서 벽 3개가 고정 된 상태 virus 가 퍼진다.
	// index = 0 ~ NxM-1
	
	static int N, M, safe, maxIdx, maxSafe, tempSafe;
	static int[][] lab;
	static int[] comb;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j ++) {
				int curr = Integer.parseInt(st.nextToken());
				if(curr == 0) safe++;
				lab[i][j] = curr;
			}
		}

		
		maxSafe = 0;
		comb = new int[3];
		
		maxIdx = N * M;
		
		getComb(0,0);
		
		System.out.println(maxSafe);
	
	}
	
	static void getComb(int labIdx, int currIdx) {
		// 벽 조합을 하나 만들었다.
		if(currIdx == 3) {
			int temp = getSafeSpace();

			if(temp > maxSafe) maxSafe = temp; return;
		}
		if(labIdx == maxIdx) return;
		// 좌표가 0인지 체크
		// 좌표가 벽을 넣을 수 없는 좌표이면 무조건 다음 인덱스로 스킵
		if(lab[labIdx/M][labIdx%M] == 0) {
			comb[currIdx] = labIdx;
			getComb(labIdx + 1, currIdx + 1); 
		}
		getComb(labIdx + 1, currIdx);
	}
	
	static int getSafeSpace() {		
		visited = new boolean[N][M];
		tempSafe = safe;
		int [][] coordinates = new int[3][2];
		// 인덱스를 좌표로 바꾸어 준다.
		for(int i = 0; i < 3; i ++) {
			coordinates[i][0] = comb[i] / M;
			coordinates[i][1] = comb[i] % M;
			// 벽으로 꾸어준다.
			lab[coordinates[i][0]][coordinates[i][1]] = 1;
		}
		tempSafe-=3;

		
		// bfs 시도
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j ++) {
				if(lab[i][j] == 2) {
					// 바이러스 bfs 시도
					visited[i][j] = true;
					dfs(i, j);
				}
			}
		}
		
		
		for(int i = 0; i < 3; i ++) {
			lab[coordinates[i][0]][coordinates[i][1]] = 0;
		}
 		
		return tempSafe;
	}
	
	static void dfs(int y, int x) {
		for(int i = 0; i < 4; i ++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty < 0 || ty >= N || tx < 0 || tx >= M || visited[ty][tx] == true || lab[ty][tx] != 0) continue;
			visited[ty][tx] = true;
			tempSafe --;
			dfs(ty, tx);
		}
		
	
	}

}
