package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Adelie3 {

	static String[][] map;
	static boolean[][][] visited; // 무기에 따라 달라짐
	static boolean[][] fought;
	static int[] dy = { -1, 1, 0, 0 }; // 0,1,2,3 <= 1,2,3,4,
	static int[] dx = { 0, 0, 1, -1 };
	static int min, N, M;
	static Node penguin;

	// G = 5, S = 3, B = 2 3, 2, 1
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long beforeTime = System.currentTimeMillis();
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
		fought = new boolean[N][M];

		dfs(penguin);

		if (min == Integer.MAX_VALUE)
			min = -1;

//		System.out.println(Arrays.deepToString(map));
//		System.out.println(penguin.toString());
		System.out.println(min);
		long afterTime = System.currentTimeMillis();
		
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);

	}

	static void dfs(Node curr) {
		System.out.println(curr.toString());
		if (map[curr.y][curr.x].equals("O")) {
			// 집 도착!
			if (curr.move < min) min = curr.move;
			return;
		} else {
			if(curr.move >= min - 1) return;
			visited[curr.weapon][curr.y][curr.x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];

				if (ny >= N || ny < 0 || nx >= M || nx < 0 || visited[curr.weapon][ny][nx] || map[ny][nx].equals("X")) 	continue;

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
					dfs(new Node(ny, nx, a, w, curr.move + 1));

					continue;
				} else if (map[ny][nx].equals(".") || map[ny][nx].equals("O")) {
					// 그냥 가면 됨
					dfs(new Node(ny, nx, curr.attack, curr.weapon, curr.move + 1));
					continue;
				} else {// 숫자일 때 -> 동물일 때
						// 결투를 신청한다

					// 이미 싸웠으면 안함
					int time = 1;

					if (!fought[ny][nx]) {
						int enemy = Integer.parseInt(map[ny][nx]);
						int add = enemy % curr.attack == 0 ? 0 : 1;
						int fightTime = enemy / curr.attack + add;
						// map[ny][nx] = ".";
						time += fightTime;
					}
					fought[ny][nx] = true;
					dfs(new Node(ny, nx, curr.attack, curr.weapon, curr.move + time));
					fought[ny][nx] = false;

				}

			}
			visited[curr.weapon][curr.y][curr.x] = false;
		}
	}

	static class Node {
		int y, x, attack, weapon, move;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			this.attack = 1;
			this.weapon = 0;
			this.move = 0;
		}

		public Node(int y, int x, int attack, int weapon, int move) {
			this.y = y;
			this.x = x;
			this.attack = attack;
			this.weapon = weapon;
			this.move = move;
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
