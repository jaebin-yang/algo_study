package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_달이차오른다가자_1194 {
	
	static boolean[] hasKey;
	static boolean [][][] visited;
	static char[][] map;
	static int N, M;
	static Node node;
	
	// a, b, c, d, e, f
	// 1, 2, 3, 4, 5, 6
	
	
	//열쇠는 어떻게.....??????? // 조합만큼 필요...?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i ++) {
			String s = br.readLine();
			for(int j = 0; j < M; j ++) {
				char curr = s.charAt(j);
				if(curr == '0') {
					node = new Node(i, j);
				}
				map[i][j] = curr;
			}
		}
		
		visited = new boolean[7][N][M];
		hasKey = new boolean[7]; // 0 is placeholder
		
		bfs();
		for(int i = 0; i < N; i ++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println('a' - '0');
		
		
	}
	
	static void bfs() {
		
	}
	
	static class Node {
		int y, x, c, k;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			c = 0;
			k = 0;
		}
		
	}

}
