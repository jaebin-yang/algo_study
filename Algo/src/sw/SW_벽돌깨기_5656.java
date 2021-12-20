package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_벽돌깨기_5656 {

	static int T, N, W, H, count, min, currCount;
	static int[][] map;
	static int[] marbles;
	static int[][] temp;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			temp = new int[H][W];
			count = 0;
			min = Integer.MAX_VALUE;
			for(int i = 0; i < H; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j ++) {
					int curr = Integer.parseInt(st.nextToken());
					if(curr>0) count++;
					map[i][j] = curr;
				}
			}

			marbles = new int[N];
			comb(0);
			System.out.println("#" + t + " " + min);
		}

	}

	static void comb(int tgtIdx) {
		if(min==0) return;
		if(tgtIdx == N) {
			for(int i = 0; i < H; i ++) {
				temp[i] = Arrays.copyOf(map[i], W);
			}
			currCount = count;
			for(int i = 0; i < N; i ++) {
				drop(i);
				rearrange();
			}

			min = Math.min(min, currCount);
			return;
		}

		for(int i = 0; i < W; i ++) {
			marbles[tgtIdx] = i;
			comb(tgtIdx +1);
		}
	}

	static void drop(int idx) {
		int y = 0; int x = marbles[idx];
		for(int i = 0; i < H; i ++) {
			if(y < 0 || y >= H || x < 0 || x >= W) break;
			if(temp[y][x] != 0) {
				explode(y, x);
				break;
			}
			y = y + dy[1];
			x = x + dx[1]; 
		}	

	}

	static void explode(int y, int x) {
		int range = temp[y][x];
		temp[y][x] = 0;
		currCount --;
		if(currCount == 0) {
			min = currCount;
			return;
		}
		for(int j = 1; j < range; j ++) {
			for(int i = 0; i < 4; i ++) {
				int ny = y + dy[i] * j;
				int nx = x + dx[i] * j;
				if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
				if(temp[ny][nx]!=0) explode(ny, nx);
			}
		}

	}

	static void rearrange() {
		for(int j = 0; j < W; j ++) {
			for(int i = H-2; i >= 0; i --) {
				if(temp[i][j] != 0) {
					int ny = i + dy[1];
					if(temp[ny][j] == 0) {
						while(ny <= H-1 && temp[ny][j] == 0) {
							ny = ny + dy[1];
						}
						temp[ny-1][j] = temp[i][j];
						temp[i][j] = 0;
					}
				}
			}
		}
	}

}
