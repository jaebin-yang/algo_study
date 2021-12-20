package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Ladder1_1210 {
	
	static int[][] ladder = new int[100][100];
	static int sy, sx, ans;
	// 왼 -> 오 -> 위
	// 오 -> 왼 -> 위
	// 위로 이동하면서 delta 사용 이때, 왼 혹은 오른쪽이 먼저 가능하면 선택해서 가야 함
	static int[] dy = {0, 0, -1,};
	static int[] dx = {-1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("SW_1210_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t ++) {
			br.readLine();
			for(int i = 0; i < 100; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j ++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
		
		
		sy = 99;
		for(int i = 0; i < 100; i ++) {
			if(ladder[sy][i] == 2) {
				sx = i;
				break;
			}
		}

		
		// 탐색
		int dir = 2; 
		while(true) {
			
			// 위로 갈 경우: 왼쪽 오른쪽이 갈수 있으면 먼저 선택 아니면 위로 계속 같다. 
			
			// 옆ㅇ로 갈 경우: 외ㅟ로 갈 수 있으면 위로 먼저 선택 아니면 그 방향으로 계속 간다. 
			if(dir == 2) {
				for(int d = 0; d < 3; d ++) {
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					
					if(ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && ladder[ny][nx] == 1) {
						sy=ny;
						sx=nx;
						dir = d; // 방향전환
						break;
						
					}
				}	
			}else if (dir==0||dir ==1) {
				// 위로 가는 좌표
				int ny = sy + dy[2];
				int nx = sx + dx[2];
				if(ny >=0 && nx >= 0 && ny < 100 && nx < 100 && ladder[ny][nx] == 1) {
				sy=ny;
				sx=nx;
				dir=2; // 방향 전환
				}else {
					sy = sy+ dy[dir];
					sx = sx + dx[dir];
				}
				
			}
			
			// 꼭대기
			if(sy == 0) {
				ans = sx; 
				break;
			}
			
		}
		
		System.out.println("#"+ " " + ans);
		
		}
	}
}
