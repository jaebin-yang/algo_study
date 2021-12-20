package bj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_치즈_2636_redux {
	static int[][] board;
	static int hour, N, M;
	static int cheeseCount;
	static int prevCheeseCount;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int cheeseMin_x, cheeseMax_x, cheeseMin_y, cheeseMax_y;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) cheeseCount ++;
				board[i][j] = temp;

			}
		}

		while(cheeseCount > 0) {
			prevCheeseCount = cheeseCount;
			visited = new boolean[N][M];
			dfs(0,0);
			
			
			hour++;
		}
		
		System.out.println(hour);
		System.out.println(prevCheeseCount);

	}
	
	static void dfs(int y, int x) {
		if(visited[y][x] == false) {
		visited[y][x] = true;
		if(board[y][x] == 1) {
			cheeseCount --;
			board[y][x] = 0; return;
		}
		for(int i = 0; i < 4; i ++) {
			if(y+dy[i] >= 0 && y+dy[i] < N && x+dx[i] >= 0 && x+dx[i] < M) dfs(y + dy[i], x + dx[i]);
		}
		}
	}


}
