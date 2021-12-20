package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class BJ_알파벳_1987_2 {

	static int R, C, max;
	static char[][] map;
	//static boolean[] visit = new boolean[26]; // 'A' : 0
	static Queue<Node> queue = new LinkedList<Node>();
	
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
		
		bfs();
		
		System.out.println(max);
	}

	static void bfs() {
		
		queue.offer(new Node( 0, 0, 1, 0 | 1<<map[0][0]-'A')); // 'C' - 'A' => 2 // 0001 -> 0100
		
		while( ! queue.isEmpty() ) {
			Node node = queue.poll();
			max = Math.max(max, node.cnt);
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				// 범위 체크, 이전 알파벳 사용 확인
				// 체크 동시에 기저조건
				if( ny < 0 || nx < 0 || ny >= R || nx >= C 
						|| (node.visit & 1<<map[ny][nx]-'A') != 0 ) continue;
				
				queue.offer(new Node(ny, nx, node.cnt + 1, node.visit | 1<<map[ny][nx]-'A'));
			}
		}
	}
	
	static class Node{
		int y;
		int x;
		int cnt;
		int visit;
		
		public Node(int y, int x, int cnt, int visit) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.visit = visit;
		}
	}
}










