package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class SW_재미있는오셀로게임_4615 {
	static int T, N, M, W, B, y, x, curr, enemy, count;
	static int[][] board;
	static int [] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int [] dx = {-1, 0, 1, -1, 1, -1, 0, 1};



	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = 0; B  = 0;
			board =  new int[N+1][N+1]; //row 0, column 0 : placeholder
		
			// B = 1, W = 2 None = 0;
			board[N/2][N/2] = 2;
			board[N/2][N/2 + 1] = 1;
			board[N/2 + 1][N/2] = 1;
			board[N/2 + 1][N/2 + 1] = 2;


			for(int i = 0; i < M; i ++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				curr = Integer.parseInt(st.nextToken());
				if(board[y][x] == 0) {
					enemy = enemy(curr);

					count = 0;
					for(int k = 0; k < 8; k ++) {
						int ty = y + dy[k];
						int tx = x + dx[k];
						if(ty > 0 && ty <= N && tx > 0 && tx <= N && board[ty][tx]==enemy)  {
							dfs(ty ,tx, k);
						}
					}

					if(count > 0) board[y][x] = curr;
				}
				
			}

			for(int i = 1; i <= N; i ++) {
				for(int j = 1; j <= N; j ++) {
					if(board[i][j] == 1) B++;
					else if(board[i][j] == 2) W++;
				}
			}

			System.out.println("#" + t + " " + B + " " + W);
		}

	}

	static boolean dfs (int y, int x, int k) {

	
		
			if(board[y][x] == curr) return true;
			else if(board[y][x] == enemy) {
				int ty = y + dy[k];
				int tx = x + dx[k];
				if(ty > 0 && ty <= N && tx > 0 && tx <= N) {
					if(dfs(ty, tx, k)) 
					{
						board[y][x] = curr;
						count++;
						return true;
					}
				}
			}
			return false;
	
	}

	static int enemy(int curr) {
		if(curr == 1) return 2;
		else return 1;
	}




}
