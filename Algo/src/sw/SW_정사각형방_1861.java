package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_정사각형방_1861 {

	static int[][] rooms;
	static int Max, MaxRoom, T, N, temp;
	static int dy[] = {1, -1, 0,  0};
	static int dx[] = {0,  0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_1861.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			Max = 0;
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					temp = move(i, j);
					if(Max < temp) {
						Max = temp;
						MaxRoom = rooms[i][j];
					}
					else if (Max == temp) {
						if(MaxRoom > rooms[i][j]) {
							MaxRoom = rooms[i][j];
						}
					}
				}
			}
			
			System.out.println("#"+ t + " " + MaxRoom + " " + Max);
			
			
			
			
		}
	}
	
	static int move(int y, int x) {
		int path = 1; int tx = 0; int ty = 0;
		for(int i = 0; i < 4; i ++) {
			ty = y + dy[i];
			tx = x + dx[i];
			if(ty >= 0 && ty < N && tx >= 0 && tx < N && rooms[ty][tx] == rooms[y][x] + 1) {
				path += move(ty, tx);
			}
		}
		
		return path;
	}

}
