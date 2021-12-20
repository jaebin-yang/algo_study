package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기1_16926 {

	static int N, M, R, toRotate;
	static int[][] array;

	static int[] dy = {1, 0, -1, 0}; // (0,0) 부터 회전
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		// 한 레이어씩 반시계방향으로 돌리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		array = new int[N][M];

		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		toRotate = Math.min(N,M) / 2;

		for(int i = 0; i < R; i ++) {
			rotateCounterClockwise(0);
		}
		
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j ++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}


	static void rotateCounterClockwise(int count) {
		if(count == toRotate) return;

		int x, y, temp1, temp2;
		y = count; x = count; 
		temp1 = array[y][x];
		for(int i = count; i < N-count-1; i ++) {
			y += dy[0];
			x += dx[0];
			temp2 = array[y][x];
			array[y][x] = temp1;
			temp1 = temp2;
		}
		for(int i = count; i < M-count-1; i ++) {
			y += dy[1];
			x += dx[1];
			temp2 = array[y][x];
			array[y][x] = temp1;
			temp1 = temp2;
			
		}		
		for(int i = count; i < N-count-1; i ++) {
			y += dy[2];
			x += dx[2];
			temp2 = array[y][x];
			array[y][x] = temp1;
			temp1 = temp2;
		}
		for(int i = count; i < M-count-1; i ++) {
			y += dy[3];
			x += dx[3];
			temp2 = array[y][x];
			array[y][x] = temp1;
			temp1 = temp2;
		}
		rotateCounterClockwise(count + 1);
	}

}
