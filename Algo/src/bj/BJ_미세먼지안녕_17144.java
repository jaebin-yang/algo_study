package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {

	static int R, C, T;
	static int[][] map, temp;
	static Node[] airFilter = new Node[2];

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i < R; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j ++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == -1) {
					if(airFilter[0] == null) {
						airFilter[0] = new Node(i, j);
					}
					else airFilter[1] = new Node(i, j);
				}
				map[i][j] = temp;
			}
		}

		// run simulation
		for(int t = 0; t < T; t ++) {
			// 미세먼지 확산
			dust();
			// 공기청정기 작동
			airFilter();
		}
		
		// 미세먼지 양 출력
		getTotal();
	}

	static void dust() {
		temp = new int[R][C];

		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j ++) {
				if(map[i][j] == -1) { // 공기청정기일때
					temp[i][j] = map[i][j];
					continue;
				}
				if(map[i][j] > 0) { // 미세먼지 일때
					int count = 0;
					int val = map[i][j] / 5;
					if(val == 0) {
						temp[i][j] += map[i][j];
						continue;
					}
					for(int s = 0; s < 4; s ++) {
						int ty = i + dy[s];
						int tx = j + dx[s];
						if(ty < 0 || ty >= R || tx < 0 || tx >= C) continue;
						if(map[ty][tx] == -1) continue;
						temp[ty][tx] += val;
						count++;
					}
					temp[i][j] += map[i][j] - val * count;
				}
			}
		}
		map = temp;
	}

	static int[] ccwY = {0, -1, 0, 1};
	static int[] ccwX = {1, 0, -1, 0};

	static int[] cwY = {0, 1, 0, -1};
	static int[] cwX = {1, 0, -1, 0};
	static void airFilter() {
		// 위에거는 위로 시계반대방향
		// 오른쪽 -> 위로 -> 왼쪽 -> 아래로
		
		for(int i = 0; i < 2; i ++) {
			int dir = 0;
			int [] afy, afx;
			int y = airFilter[i].y;
			int x = airFilter[i].x;
			if(i == 0) {
				afy = ccwY;
				afx = ccwX;
			}
			else {
				afy = cwY;
				afx = cwX;
			}
			int ty = y + afy[dir];
			int tx = x + afx[dir];
			int temp = map[ty][tx];
			map[ty][tx] = 0;
			while(true) {
				y = ty; x = tx;
				ty = y + afy[dir];
				tx = x + afx[dir];
				if(ty < 0 || ty >= R || tx < 0 || tx >= C) {
					dir ++;
					ty = y + afy[dir];
					tx = x + afx[dir];
				}
				if(map[ty][tx] == -1) {
					break;
				}
				int curr = map[ty][tx];
				map[ty][tx] = temp;
				temp = curr;
			}
		}
	}


	static void getTotal() {
		int result = 0;
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j ++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}

	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
