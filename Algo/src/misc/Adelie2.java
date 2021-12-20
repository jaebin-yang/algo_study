package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Adelie2 {

	static String[][] map;
	static boolean[][][] visited; // 무기에 따라 달라짐
	static int attack = 0;
	static int[] dy = { -1, 1, 0, 0 }; // 0,1,2,3 <= 1,2,3,4,
	static int[] dx = { 0, 0, 1, -1 };
	static int min, N, M;
	static Node penguin;

	// G = 5, S = 3, B = 2 3, 2, 1
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

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
		// start bfs
		visited = new boolean[4][N][M]; // 무기없, 활, 칼, 총


		dfs(penguin);

		if (min == Integer.MAX_VALUE)
			min = -1;

//		System.out.println(Arrays.deepToString(map));
//		System.out.println(penguin.toString());
		System.out.println(min);

	}

	static void dfs(Node curr) {
		System.out.println(curr);
		if(curr.move >= min) return;
		if (map[curr.y][curr.x].equals("O")) {
			// 집 도착!
			if (curr.move < min)
				min = curr.move;
		} else {
			visited[curr.weapon][curr.y][curr.x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];

				if (ny >= N || ny < 0 || nx >= M || nx < 0 || visited[curr.weapon][ny][nx] || map[ny][nx].equals("X"))
					continue;

				visited[curr.weapon][curr.y][curr.x] = true;
				// 무기가 있을 때
				int w = 0;
				int a = 0;
				if (map[ny][nx].equals("B") || map[ny][nx].equals("S") || map[ny][nx].equals("G")) {
					switch (map[ny][nx]) {
					case "B":
						if (curr.attack-1 < 2) {
							w = 1;
							a = 3;
						}
						break;
					case "S":
						if (curr.attack-1 < 3) {
							w = 2;
							a = 4;
						}
						break;
					case "G":
						if (curr.attack-1 < 5) {
							w = 3;
							a = 6;
						}
						break;
					}
					if(w == 0) {
						w = curr.weapon;
						a = curr.weapon;
					}
					dfs(new Node(ny, nx, a, w, curr.move + 1, curr.fought));

					continue;
				} else if (map[ny][nx].equals(".") || map[ny][nx].equals("O")) {
					// 그냥 가면 됨
					dfs(new Node(ny, nx, curr.attack, curr.weapon, curr.move + 1, curr.fought));
					continue;
				} else {// 숫자일 때 -> 동물일 때
						// 결투를 신청한다

					// 이미 싸웠으면 안함
					boolean fought = false;
					for (int j = 0; j < curr.fought.size(); j++) {
						if (curr.fought.get(j).y == ny && curr.fought.get(j).x == nx) {
							fought = true;
							break;
						}
					}
					int time = 1;
					ArrayList<Enemy> newFought = (ArrayList<Enemy>) curr.fought.clone();
					if (!fought) {
						int enemy = Integer.parseInt(map[ny][nx]);
						int add = enemy % curr.attack == 0 ? 0 : 1;
						int fightTime = enemy / curr.attack + add;
						// map[ny][nx] = ".";
						time += fightTime;
						newFought.add(new Enemy(ny, nx));
					}
					dfs(new Node(ny, nx, curr.attack, curr.weapon, curr.move + time, newFought));

				}

			}
			visited[curr.weapon][curr.y][curr.x] = false;
		}
	}

	static class Node {
		int y, x, attack, weapon, move;
		ArrayList<Enemy> fought;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			this.attack = 1;
			this.weapon = 0;
			this.move = 0;
			fought = new ArrayList<Enemy>();
		}

		public Node(int y, int x, int attack, int weapon, int move, ArrayList<Enemy> fought) {
			this.y = y;
			this.x = x;
			this.attack = attack;
			this.weapon = weapon;
			this.move = move;
			this.fought = fought;

		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", attack=" + attack + ", weapon=" + weapon + ", move=" + move + "]";
		}

	}

	static class Enemy {
		int y, x;

		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
