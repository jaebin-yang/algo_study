package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_달팽이숫자_1954_2 {

	static int T, N;
	static int[][] snail;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			snail = new int[N][N];
			
			int dir = 1; // 증가 방향(1), 감소방향(-1)
			int count = N; // 채워가는 칸 수
			int num = 1; // 증가하는 수 1 -> 2 -> 3 ...
			int y = 0; 
			int x =-1;
			
			while(num <= N*N) {
				// 우->좌->우...
				for(int i = 0; i < count; i ++) {
					x += dir;
					snail[y][x] = num++;
				}
				
				count --;
				for(int i = 0; i < count; i ++) {
					y += dir;
					snail[y][x] = num++;
				}
				
				dir = dir * -1;
			
			}
			
	

			// 출렧
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
