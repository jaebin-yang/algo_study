package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이_2563 {
	
	static int N, ans;
	static boolean[][] map = new boolean[100][100];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			for (int j = sy; j < sy + 10; j++) {
				for (int k = sx; k < sx + 10; k++) {
					if( ! map[j][k] ) {
						map[j][k] = true;
						ans++;
					}
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]) ans++;
			}
		}
		
		System.out.println(ans);
	}
}
