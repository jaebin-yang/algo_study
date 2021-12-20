package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_빵집_3109_2 {
	static int R, C, count;
	static char [][] map;
	static int[] dy = {-1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i ++) {
			String s = br.readLine();
			for(int j = 0; j < C; j ++) {
				map[i][j] = s.charAt(j);
			}
		}
		count = 0;
		for(int i = 0; i < R; i ++) {
			pipeline(i, 0);
		}
		
		System.out.println(count);
		
	}
	
	static boolean pipeline(int y, int x) {
		if(x == C - 1) {
			count ++; return true;
		}
		
		for(int i = 0; i < 3; i ++) {
			int ty = y + dy[i];
			int tx = x + 1;
			
			if(canUse(ty, tx)) {
				map[ty][tx] = 'x';
				if(pipeline(ty, tx)) return true;
			}
		}
		return false;
	}
	
	static boolean canUse(int y, int x) {
		if(x < C  && x >= 0 && y < R && y >= 0 && map[y][x] == '.') {return true;}
		return false;
	}
}
