package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_감시_15683 {
	static int N, M;
	static int[][] office;
	ArrayList<int[][]> cameras = new ArrayList<>();
	static int numWalls, numSurveillance;
	static int blindspots;
	// index 0, 1, 2, 3
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	
	// dy dx 조합
	static int[][] one = {{0}, {1}, {2}, {3}};
	static int[][] two = {{0, 2}, {1, 3}};
	static int[][] three = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
	static int[][] four = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
	static int[][] five = {{0, 1, 2 ,3}};
	
	public static void main(String[] args) throws Exception {
		ArrayList<int[][]> cameras = new ArrayList<>();
		cameras.add(one);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		office = new int[N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j > M; j ++) {
				int element = Integer.parseInt(st.nextToken());
				if(element == 6) numWalls ++;
				if(element == 1 || element == 2 || element == 3 || element == 4 || element ==5) numSurveillance ++;
				office[N][M] = element;
			}
		}
		
		blindspots = 0;
		
	}

}
