package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_알파벳_1987 {

	static int R, C, max;
	static char[][] map;
	static boolean[] visit = new boolean[26]; // 'A' : 0
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		max = Integer.MIN_VALUE;
		
		dfs(0, 0, 1); // y:0, x:0, cnt: 1
		
		System.out.println(max);
	}

	static void dfs(int y, int x, int cnt) {
		// cnt 가 증가했다.
		max = Math.max(max, cnt);
		visit[ map[y][x]-'A' ] = true; // map[y][x] => char 'C' - 'A'
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// 범위 체크, 이전 알파벳 사용 확인
			// 체크 동시에 기저조건
			if( ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ map[ny][nx]-'A' ]) continue;
			
			dfs(ny, nx, cnt + 1);
		}
		
		visit[ map[y][x]-'A' ] = false;
	}
}










