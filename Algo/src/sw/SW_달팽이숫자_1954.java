package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_달팽이숫자_1954 {

	static int T, N;
	static int[][] snail;
	// 우 하 좌 상 순서
	static int [] dy = {0, 1, 0, -1};
	static int [] dx = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			snail = new int[N][N];
			
			int y = 0;
			int x = 0;
			int d = 0; // delta index
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 현재 위치 snail[y][x] 에 값을 지정
					// y,x 는 계산된 (i*N + j + 1) 값이 저장되는 위치
					snail[y][x] = i*N + j + 1; // 반복문이 하나씩 수행될 때마다 증가하는 값 (i, j로 계산)
					
					
					// 방향 전황을 해야 하는지 확인
					// if else if에 걸리면 방향전환 d가 변한다
					// 안걸리면 같은 방향으로 계속 이동할 수 있다. 
					if(d==0) { // 우
						if(x + dx[d] >= N || snail[y][x + dx[d]]!= 0) { // 새로 우측으로 한칸 이동한 위치에 => 끝 이미 다른 숫자
							d = 1;
						}
					}
					else if(d==1) { // 하
						if(y + dy[d] >= N || snail[y + dy[d]][x]!= 0) { // 
							d = 2;
						}
					}
					else if(d==2) { // 하
						if(x + dx[d] < 0 || snail[y][x+ dx[d]]!= 0) { // 
							d = 3;
						}
					}
					else if(d==3) { // 하
						if(y + dy[d] < 0 || snail[y + dy[d]][x]!= 0) { // 
							d = 0;
						}
					}
					
					y += dy[d];
					x += dx[d];
				}
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
