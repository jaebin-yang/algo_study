package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이_1600_redux {

	static int [][] area;
	static int K;
	static int H, W;
	// 말처럼 이동
//	static int[] dy_h = {-2, -1, -2, -1, 1, 2, 2, 1};
//	static int[] dx_h = {-1, -2, 1, 2, -2, -1, 1, 2};
	
	static int[] dy_h = { 1,  1, -2, -2, -1, -1, 2,  2 };
	static int[] dx_h = { 2, -2,  1, -1,  2, -2, 1, -1 };
	// 원숭이 이동
	static int[] dy_m = {0, 0, -1, 1};
	static int[] dx_m = {1, -1, 0, 0};

	static int steps;


	static boolean[][][] visited;
	
//	static Queue<Monkey> queue = new LinkedList<>();

//	static Monkey m;


	// 0, 0 에서 H-1, W-1로

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		area = new int[H][W];
		for(int i = 0; i < H; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j ++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[K+1][H][W];

		steps = Integer.MAX_VALUE;
//		m = new Monkey(0,0, 0, K);
//
//		bfs();


		if(steps == Integer.MAX_VALUE) steps = -1;
		System.out.println(steps);



	}
	
//	public static void bfs() {
//		queue.add(m);
//		
//		while(!queue.isEmpty())	{
//			Monkey temp = queue.poll();
//			if(temp.y == H-1 && temp.x == W-1) {
//				if(temp.step < steps) steps = temp.step;
//				return;
//			}
//		}
//	}

//	public static void dfs(int count) {
//		//System.out.println(m.y + " " + m.x + " count: " + count);
//		if(m.y == H-1 && m.x == W-1) {
//			// 원숭이가 도착지점에 도착했을 때
////			System.out.println("도착! " + count);
//			if(count < steps) steps = count;
//			return;
//		}
//		// 처음으로 k 사용 안했을 때
//		System.out.println(K);
//		if(K > 0) {
//			// k의 값이 아직 유효할 때
//			// 말처럼 가보는 것도 시도한다.
//			for(int i = 0; i < dy_h.length; i ++) {
//				int ty = m.y + dy_h[i];
//				int tx = m.x + dx_h[i];
//				if(ty < 0 || ty >= H || tx < 0 || tx >= W) continue;
//				if(area[ty][tx] == 1 || visited_h[ty][tx] == true) continue;
//				
//				
//
//				m.y = ty; m.x = tx;
//				visited_h[ty][tx] = true;
//				K --;
//				dfs(count+1);
//				K++;
//
//				visited_h[ty][tx] = false;
//			}
//		}
//		for(int i = 0; i < 4; i ++) {
//			int ty = m.y + dy_m[i];
//			int tx = m.x + dx_m[i];
//			if(ty < 0 || ty >= H || tx < 0 || tx >= W) continue;
//			// 가고 싶은 자리에 장애물이 있거나, 이미 갔던 곳일 때
//			if(area[ty][tx] == 1 || visited_m[ty][tx] == true) continue;
//			if(visited_h[ty][tx] == true) continue;
//			m.y = ty; m.x = tx;
//			visited_m[ty][tx]  = true;
//			dfs(count+1);
//			visited_m[ty][tx] = false;
//		}
		
		
		
		
		
		
		
		
		
		
		
		
//
//		if(K > 0) {
//			// k의 값이 아직 유효할 때
//			// 말처럼 가보는 것도 시도한다.
//			for(int i = 0; i < dy_h.length; i ++) {
//				int ty = m.y + dy_h[i];
//				int tx = m.x + dx_h[i];
//				if(ty < 0 || ty >= H || tx < 0 || tx >= W) continue;
//				if(area[ty][tx] == 1 || visited_h[ty][tx] == true) continue;
//				
//
//				m.y = ty; m.x = tx;
//				visited_h[m.y][m.x] = true;
//				dfs(count);
//				K --;
//				visited_h[m.y][m.x] = false;
//			}
//		}


//
//		return;

	}

//	static class Monkey {
//		int y, x, step, h;
//		public Monkey(int y, int x, int step, int h) {
//			this.y =y;
//			this.x =x;
//			this.step = step;
//			this.h = h;
//		}
//	}


