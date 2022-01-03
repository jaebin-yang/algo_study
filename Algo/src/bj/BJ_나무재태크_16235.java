package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_나무재태크_16235 {
	static int N, M, K;
	static int[][] A; // 양분 값
	static Node[][] map;
	// r c는 1부터
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		map = new Node[N][N];
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Node();
			}
		}
		
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			map[y][x].trees.add(age);
		}
		
		// K년 만큼 키우기
		for(int k = 0; k < K; k ++) {
			// Spring + Summer
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					int foodToAdd = 0;
					if(map[i][j].trees.size() == 0) continue;
					Collections.sort(map[i][j].trees);
					for(int t = 0; t < map[i][j].trees.size(); t ++) {
						if(map[i][j].food < map[i][j].trees.get(t)) {
							foodToAdd += map[i][j].trees.get(t) / 2;
							map[i][j].trees.remove(t);
							t --;
						}
						else {
							map[i][j].food -= map[i][j].trees.get(t);
							map[i][j].trees.set(t, map[i][j].trees.get(t) + 1);
						}
					}
					map[i][j].food += foodToAdd;
 				}
			}
			
			// Fall + Winter
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					if (map[i][j].trees.size() > 0) {

						for (int t = 0; t < map[i][j].trees.size(); t++) {
							if (map[i][j].trees.get(t) % 5 == 0) {
								for(int z = 0; z < 8; z ++) {
									int ny = i + dy[z];
									int nx = j + dx[z];
									if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
									map[ny][nx].trees.add(1);
								}
							}
						}
					}
					map[i][j].food += A[i][j];
					
 				}
			}
			
			
		}
		
		// count number of trees
		int count = 0;
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				count += map[i][j].trees.size();
			}
		}
		System.out.println(count);
	}
	
	
	static class Node {
		ArrayList<Integer> trees; // 나이로 구분
		int food;
		public Node() {
			this.food = 5; // 기본적으로 5에서 시작
			this.trees = new ArrayList<Integer>();
		}
		@Override
		public String toString() {
			return "Node [trees=" + trees + "]";
//			return "Node [trees=" + trees + ", food=" + food + "]";
		}
		
	}

}
