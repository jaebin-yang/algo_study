package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution {

	static String[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int min, N, M, T;
	static Node penguin;
	static Queue<Node> queue = new LinkedList<Node>();

	// G = 5, S = 3, B = 2 3, 2, 1

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//long beforeTime = System.currentTimeMillis();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());


//			System.gc();
//			// 실행전 메모리 사용량 조회
//			long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new String[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < M; j++) {
					String s = st.nextToken();
					if (s.equals("P")) { // 펭귄 찾
						penguin = new Node(i, j);
						s = ".";
					}
					map[i][j] = s;
				}
			}

			min = Integer.MAX_VALUE;
			queue.offer(penguin);
			while (!queue.isEmpty()) {
				Node curr = queue.poll();
				if (map[curr.y][curr.x].equals("O")) {
					// 집 도착!
					if (curr.move < min)
						min = curr.move;
					continue;
				} else {
					if (curr.move >= min - 1)
						continue;
					curr.visited[curr.y][curr.x] = true;
					for (int i = 0; i < 4; i++) {
						int ny = curr.y + dy[i];
						int nx = curr.x + dx[i];

						if (ny >= N || ny < 0 || nx >= M || nx < 0 || curr.visited[ny][nx] || map[ny][nx].equals("X"))
							continue;

						if (map[ny][nx].equals("B") || map[ny][nx].equals("S") || map[ny][nx].equals("G")) {
							int w = 0;
							int a = 0;
							switch (map[ny][nx]) {
							case "B":
								if (curr.attack - 1 < 2) {
									w = 1;
									a = 3;
								}
								break;
							case "S":
								if (curr.attack - 1 < 3) {

									w = 2;
									a = 4;
								}
								break;
							case "G":
								if (curr.attack - 1 < 5) {
									w = 3;
									a = 6;
								}
								break;
							}
							if (w == 0) {
								// 무기 교체
								queue.offer(new Node(ny, nx, curr.attack, curr.weapon, curr.move + 1, curr.fought,
										curr.visited));
							} else {
								boolean[][] newVisited = new boolean[N][M];
								newVisited[ny][nx] = true;
								queue.offer(new Node(ny, nx, a, w, curr.move + 1, curr.fought, newVisited));
							}

							continue;
						} else if (map[ny][nx].equals(".") || map[ny][nx].equals("O")) {
							// 그냥 가면 됨
							queue.offer(new Node(ny, nx, curr.attack, curr.weapon, curr.move + 1, curr.fought,
									curr.visited));
							continue;
						} else {

							boolean[][] newFought = curr.fought;
							int time = 1;
							if (!curr.fought[ny][nx]) {
								int enemy = Integer.parseInt(map[ny][nx]);
								int add = enemy % curr.attack == 0 ? 0 : 1;
								int fightTime = enemy / curr.attack + add;
								time += fightTime;
								newFought = clone(curr.fought);
								newFought[ny][nx] = true;
							}

							queue.offer(new Node(ny, nx, curr.attack, curr.weapon, curr.move + time, newFought,
									curr.visited));

						}

					}
				}
			}

			if (min == Integer.MAX_VALUE)
				min = -1;

			System.out.println("#" + t + " " + min);


//			System.gc();
//			// 실행 후 메모리 사용량 조회
//			long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//			// 메모리 사용량 측정
//			long usedMemory = (before - after);
//			System.out.println("Used Memory : " + usedMemory);
		}
		//long afterTime = System.currentTimeMillis();

		//long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
		//System.out.println("시간차이(m) : " + secDiffTime);
	}

	static boolean[][] clone(boolean[][] fought) {
		boolean[][] newFought = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newFought[i][j] = fought[i][j];
			}
		}
		return newFought;
	}

	static class Node {
		int y, x, attack, weapon, move;
		boolean[][] visited;
		boolean[][] fought;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			this.attack = 1;
			this.weapon = 0;
			this.move = 0;
			fought = new boolean[N][M];
			this.visited = new boolean[N][M];
		}

		public Node(int y, int x, int attack, int weapon, int move, boolean[][] fought, boolean[][] visited) {
			this.y = y;
			this.x = x;
			this.attack = attack;
			this.weapon = weapon;
			this.move = move;
			this.fought = fought;
			this.visited = visited;

		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", attack=" + attack + ", weapon=" + weapon + ", move=" + move + "]";
		}

	}

}
