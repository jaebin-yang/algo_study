package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_광이삼의암벽등반_No_1 {
	static int min, M, N, L, T;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static Node start;
	static boolean[][][] visited;
	static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[10][M][N];
			// 출발지점 = M-1, 0
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int curr = Integer.parseInt(st.nextToken());
					if (curr == 2) {
						start = new Node(i, j);
					}
					map[i][j] = curr;
				}
			}

			queue.clear();
			queue.add(start);
			// bfs
			while (!queue.isEmpty()) {
				Node curr = queue.poll();
				System.out.println(curr);
				if (map[curr.y][curr.x] == 3) {
					if (curr.rings < min)
						min = curr.rings;
				} else {
					if (curr.rings > min)
						continue;

					boolean ringChange = false;
					int rings = 0;
					int count = 0;
					if (curr.count == 0) { // 무조건 고리를 바꿔야 한다. 
						if (map[curr.y][curr.x] == 1 && !curr.usedRing[curr.y][curr.x]) {
							ringChange = true;
						} else {continue; }
					}

					// curr.visited[curr.y][curr.x] = true;
					visited[curr.rings][curr.y][curr.x] = true;
					for (int i = 0; i < 4; i++) {
						int ny = curr.y + dy[i];
						int nx = curr.x + dx[i];

						if (ny < 0 || ny >= M || nx < 0 || nx >= N)
							continue;

						if (ringChange) {
							
							boolean[][] copyRingUsed = copy(curr.usedRing);
							copyRingUsed[curr.y][curr.x] = true;
							boolean[][] newVisited = new boolean[M][N];
							newVisited[curr.y][curr.x] = true;
							queue.add(new Node(ny, nx, curr.rings + 1, L - 1, newVisited, copyRingUsed));
						} else { // curr.count == 0 이 아닐 때
									// 그래도 줍는/안줍는 선택지 필요
								// 안 줍고 간다.
								if (!curr.visited[ny][nx]) {
									boolean[][] newVisited = copy(curr.visited);
									newVisited[curr.y][curr.x] = true;
									queue.add(new Node(ny, nx, curr.rings, curr.count - 1, newVisited,
											copy(curr.usedRing)));
								}
								// 줍고 간다
								if(map[curr.y][curr.x] == 1 && !curr.usedRing[curr.y][curr.x]) {
								boolean[][] copyRingUsed = copy(curr.usedRing);
								copyRingUsed[curr.y][curr.x] = true;
								boolean[][] newVisited2 = new boolean[M][N];
								newVisited2[curr.y][curr.x] = true;
								queue.add(new Node(ny, nx, curr.rings + 1, L - 1, newVisited2, copyRingUsed));
								}


						}
					}
				}

			}
			if (min == Integer.MAX_VALUE)
				min = -1;
			System.out.println("#" + t + " " + min);
		}

	}

	static boolean[][] copy(boolean[][] visited) {
		boolean[][] newVisited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				newVisited[i][j] = visited[i][j];
			}
		}
		return newVisited;
	}

	static class Node {
		int y, x, rings, count;
		boolean[][] visited;
		boolean[][] usedRing;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			this.rings = 0;
			this.count = L;
			this.visited = new boolean[M][N];
			this.usedRing = new boolean[M][N];
		}

		public Node(int y, int x, int rings, int count, boolean[][] visited, boolean[][] usedRing) {
			this.y = y;
			this.x = x;
			this.rings = rings;
			this.count = count;
			this.visited = visited;
			this.usedRing = usedRing;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", rings=" + rings + ", count=" + count + "]";
		}

	}

}
