package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_다리만들기2_17472 {

	// 1. 정점을 확인
	// 2. 간선(비용)
	// 3. MST (최소신장 트리) KRUSKAL / PRIM 
	// KRUSKAL 간선 중심'
	// 

	// 정점 각각 구별 가능한 영역 표시
	// 간선길이
	static int N, M;
	static int[][] map;

	static boolean[][] visited;
	static ArrayList<Island> islands;
	static ArrayList<Edge> bridges;

	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static int [][] edges;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 구분
		islands = new ArrayList<Island>();
		islands.add(new Island()); // 0는 항상 placeholder
		visited = new boolean[N][M];
		int label = 1;
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j ++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Island island = new Island(label);
					labelIsland(i, j, island);
					islands.add(island);
					label ++;

				}
			}
		}

		edges = new int[islands.size()][islands.size()];

		for(int i = 1; i < islands.size(); i ++) {
			getMinLength(islands.get(i));
		}

		
		for(int i = 0; i < islands.size(); i ++) {
			System.out.println(Arrays.toString(edges[i]));
		}
		
		// 프림 쓰면 가능

	}

	static class Island {
		int label;
		ArrayList<Node> nodes;

		public Island(int label) {
			this.label = label;
			nodes = new ArrayList<Node>();
		}

		public Island () {

		}

		@Override
		public String toString() {
			return "Island [label=" + label + ", nodes=" + Arrays.toString(nodes.toArray()) + "]\n";
		}
	}

	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}


	}

	static class Edge implements Comparable<Edge>{
		int i1, i2;
		int length;
		public Edge(int i1, int i2, int length) {
			this.i1 = i1;
			this.i2 = i2;
			this.length = length;
		}
		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}

	}


	static void getMinLength(Island i1) {
		int length = Integer.MAX_VALUE;
		for(int i = 1; i < i1.nodes.size(); i ++) {
			int y = i1.nodes.get(i).y;
			int x = i1.nodes.get(i).x;
			for(int j = 0; j < 4; j ++) {
				int ty = y + dy[j];
				int tx = x + dx[j];
				int count = 0;
				if(ty < 0 || ty >= N || tx < 0 || tx >= M || map[ty][tx] != 0) continue;
				while(ty >= 0 && ty < N && tx >= 0 && tx > 0 && tx < M && map[ty][tx] != i1.label) {
					System.out.println(count);
					int next = map[ty][tx];
					if(next != 0) {
						if(count >= 2) {
							System.out.println("put");
							if(edges[i1.label][next] == 0) {
								edges[i1.label][next] = count;
								edges[next][i1.label] = count;
								break;
							} 
							if(edges[i1.label][next] > count) {
								edges[i1.label][next] = count;
								edges[next][i1.label] = count;
								break;
							}

						}
					}

					ty = ty + dy[j];
					tx = tx + dx[j];
					count ++;

				}
			}

		}
		


	}


	static void labelIsland(int y, int x, Island island) {
		visited[y][x] = true;
		for(int i = 0; i < 4; i ++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty < 0 || ty >= N || tx < 0 || tx >= M || visited[ty][tx] || map[ty][tx] == 0) continue;
			labelIsland(ty, tx, island);
		}
		map[y][x] = island.label;
		island.nodes.add(new Node(y, x));
	}

}
