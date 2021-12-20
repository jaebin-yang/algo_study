package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SW_보급로_1249 {

	static int T, N;
	static int[][] map;
	static int[][] dijkstra;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static PriorityQueue<Node> pqueue = new PriorityQueue<Node>((Node n1, Node n2) -> 
													dijkstra[n1.y][n1.x] - dijkstra[n2.y][n2.x]);
	public static void main(String[] args) throws Exception {
		// 다익스트라!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dijkstra = new int[N][N];
			for(int i = 0; i < N; i ++) {
				String s = br.readLine();
				for(int j = 0; j < N; j ++) {
					map[i][j] = s.charAt(j) - '0';
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}
			
			pqueue.clear();
			dijkstra[0][0] = map[0][0];
			pqueue.offer(new Node(0,0));
			
			while(!pqueue.isEmpty()) {
				Node curr = pqueue.poll();
				int y = curr.y;
				int x = curr.x;
				for(int i = 0; i < 4; i ++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(dijkstra[ny][nx] > dijkstra[y][x] + map[ny][nx]) {
						dijkstra[ny][nx] = dijkstra[y][x] + map[ny][nx];
						pqueue.offer(new Node(ny, nx));
					}
				}
			}
			
			System.out.println("#" + t + " " + dijkstra[N-1][N-1]);
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
