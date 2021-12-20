package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485_dijkstra {

	static int N, count, min;
	static int[][] cave;
	static int[][] dijkstra;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static PriorityQueue<Node> queue = new PriorityQueue<Node>((Node n1, Node n2) -> dijkstra[n1.y][n1.x] - dijkstra[n2.y][n2.x]);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 1;
		while(N != 0) {
			cave = new int[N][N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// dfs? -> 시간초과 | 다익스트라?
			//(0,0)에서 출발, (N-1, N-1)도착
			queue.clear();
			dijkstra = new int[N][N];
			for(int [] row: dijkstra) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}
			dijkstra[0][0] = cave[0][0];
			queue.add(new Node(0,0));
			
			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				int y = curr.y; int x = curr.x;
				for(int i = 0; i < 4; i ++) {
					int ty = y + dy[i];
					int tx = x + dx[i];
					if(ty < 0 || ty >= N || tx < 0 || tx >= N) continue;
					if(dijkstra[y][x] + cave[ty][tx] < dijkstra[ty][tx]) {
						dijkstra[ty][tx] = dijkstra[y][x] + cave[ty][tx];
						queue.offer(new Node(ty, tx));
					}
				}
			}
			
			
			System.out.println("Problem " + count + ": " + dijkstra[N-1][N-1]);
			count ++;
			N = Integer.parseInt(br.readLine());
		}
	}
	
	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
