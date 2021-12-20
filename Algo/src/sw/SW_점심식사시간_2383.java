package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_점심식사시간_2383 {

	static int T, result, N;
	static int[][] map;
	static boolean[] selected;
	static Node sOne, sTwo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			selected = new boolean[N];
			map = new int[N][N];
			int count = 0;
			for(int i = 0; i < N; i ++) {
				
				
			}
			
			
			
		}
	}
	
	static class Node {
		int y, x, l;
		public Node(int y, int x, int l) {
			this.y = y;
			this.x = x;
			this.l = l;
		}
	}

}
