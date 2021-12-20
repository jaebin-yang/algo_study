package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_토마토_7576 {

	static int M, N, tomato, ripeTomato, days;
	static int currCount, nextCount;
	static int[][] box;
	static Queue<Node> tomatoes = new LinkedList<Node>();
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp != -1) tomato ++;
				if(temp == 1) {
					tomatoes.offer(new Node(i, j));
					ripeTomato++;
					currCount ++;
				}
				box[i][j] = temp;
				
			}
		}
		
		days = 0;
		while(!tomatoes.isEmpty()) {
			if(currCount == 0) {
				days ++;
				currCount = nextCount;
				nextCount = 0;
			}
			
			Node curr = tomatoes.poll();
			currCount --;
			for(int i = 0; i < 4; i ++) {
				int ty = curr.y + dy[i];
				int tx = curr.x + dx[i];
				
				if(ty < 0 || ty >= N || tx < 0 || tx >= M) continue;
				if(box[ty][tx] != 0) continue;
				
				box[ty][tx] = 1;
				ripeTomato ++;
				tomatoes.offer(new Node(ty, tx));
				nextCount++;
			}
	
			
			
		}
		
		if(ripeTomato == tomato) {
			System.out.println(days);
		}
		else {
			System.out.println(-1);
		}
		

	}
	
	
	static class Node {
		int y, x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
