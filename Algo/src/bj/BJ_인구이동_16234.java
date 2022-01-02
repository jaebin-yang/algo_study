package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_인구이동_16234 {
	static int N, L, R, days;
	static Country[][] map;
	static int[] dy = {0, 0, 1, -1}; // 동서남북
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L  = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new Country[N][N];
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++) {
				map[i][j] = new Country(Integer.parseInt(st.nextToken()), i, j);
			}
		}
		
		days = 0;
		boolean immigrate = false;
	
		// 각 칸의 오른쪽과 아래만 확인하면 된다.
		while(true) {
			immigrate = false;
			// 인구 이동이 필요한지 확인한다. 
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					int currP = map[i][j].population;
					// 오른쪽과 비교
					if (j < N - 1) {
						int rP = map[i + dy[0]][j + dx[0]].population;
						if (Math.abs(currP - rP) >= L && Math.abs(currP - rP) <= R) {
							immigrate = true;
							map[i][j].borders[0] = true;
							map[i + dy[0]][j + dx[0]].borders[1] = true;
						}
					}
					// 아래와 비교
					if(i < N - 1) {
					int sP = map[i+dy[2]][j+dx[2]].population;
					if(Math.abs(currP - sP) >= L && Math.abs(currP - sP) <= R) {
						immigrate = true;
						map[i][j].borders[2] = true;
						map[i+dy[2]][j+dx[2]].borders[3] = true;	
					}
					}

				}
			}
			
			if(!immigrate) break;
			// 인구이동 실시
			Queue<Node> countries = new LinkedList<Node>();
			Queue<Node> queue = new LinkedList<Node>();
			boolean[][] visited = new boolean[N][N];
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					if(visited[i][j]) continue;
					countries.clear();
					queue.clear();
					int sum = 0;
					int count = 0;
					queue.offer(new Node(i, j));
					while(!queue.isEmpty()) {
						Node curr = queue.poll();
						if(visited[curr.y][curr.x]) continue;
						visited[curr.y][curr.x] = true;
						sum += map[curr.y][curr.x].population;
						count ++;
						countries.offer(curr);
						for(int k = 0; k < 4; k ++) {
							if(!map[curr.y][curr.x].borders[k]) continue;
							int ny = curr.y + dy[k];
							int nx = curr.x + dx[k];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
							queue.offer(new Node(ny, nx));
						}
					}	

					int avg = sum / count;
					
					while(!countries.isEmpty()) {
						Node curr = countries.poll();
						map[curr.y][curr.x].population = avg;
						for(int k = 0; k < 4; k ++) {
							map[curr.y][curr.x].borders[k] = false;
						}
						
					}
				}
			
			}
			
			days++;
			
			
			
		}
		
		System.out.println(days);
		
		

	}
	
	
	static class Country {
		int population, y, x;
		boolean[] borders; // 동,서,남,북 국경선이 열려있는지 유무
		
		public Country(int population, int y, int x) {
			this.population = population;
			this.y = y;
			this.x = x;
			borders = new boolean[4]; // 기본적으로 false로 설정
		}

		@Override
		public String toString() {
			return "Country [population=" + population + ", borders=" + Arrays.toString(borders) + "]";
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
