package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_단지번호붙이기_2667_BFS {
	
	static char[][] map;
	static boolean[][] visit;
	
	static int N, cnt;
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };
	
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( map[i][j] != '1' || visit[i][j] ) continue;
				// 새로운 단지의 시작 /발견
				//cnt = 0;
				// 초기화
				bfs(i, j);
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
	
	static void bfs(int y, int x) {
		// 초기화
		queue.offer( new Node(y,x));
		cnt = 1;
		visit[y][x] = true;
		
		// 반복
		while( !queue.isEmpty()) {
			
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue; // 경계
				if( map[ny][nx] != '1' || visit[ny][nx] ) continue;
				
				queue.offer( new Node(ny, nx));
				cnt++;
				visit[ny][nx] = true;
			}			
		}
	}
	
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}





