package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_단지번호붙이기_2667_DFS_NOVISIT {
	
	static char[][] map;
	//static boolean[][] visit;
	
	static int N, cnt;
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		//visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( map[i][j] != '1' ) continue;
				// 새로운 단지의 시작 /발견
				cnt = 0;
				dfs(i, j);
				// 결과 처리
				al.add(cnt);
			}
		}
		
		Collections.sort(al);
		System.out.println(al.size());
		for (int n : al) {
			System.out.println(n);
		}
//		
//		for (int i = 0; i < al.size(); i++) {
//			System.out.println(al.get(i));
//		}
	}
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };
	
	static void dfs(int y, int x) {
		cnt++; // 현재 단지의 방문 횟수 증가
		//visit[y][x] = true; // 방문 처리
		map[y][x] =0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue; // 경계
			if( map[ny][nx] != '1') continue;
			
			dfs( ny, nx );
		}
	}
}





