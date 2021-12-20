package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_낚시왕_17143 {

	static int R, C, M, result;
	static int[][] fishing;
	static Shark[] sharks;
	static ArrayList<Integer> alive = new ArrayList<Integer>();
	// 위 아래 오른쪽 왼쪽
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new Shark[M+1];
		fishing = new int[R][C];
		alive.clear();
		for(int i = 1; i <= M; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r-1, c-1, s, d, z);
			alive.add(i);
			fishing[r-1][c-1] = i; // 인덱스로 표현
		}
		
		for(int i = 0; i < C; i ++) {
			fish(i);
		}

		System.out.println(result);

	}

	static void fish(int idx) {
		for(int i = 0; i < R; i ++) {
			if(fishing[i][idx] != 0) {
				int shark = fishing[i][idx];
				result += sharks[shark].z;
				sharks[shark] = null;
				alive.remove((Integer) shark);
				fishing[i][idx] = 0;
				break;
			}
		}

		// move sharks
		for(int i = 0; i < alive.size(); i ++) {
			move(alive.get(i));
		}

		Stack<Integer> toRemove = new Stack<Integer>();
		Iterator<Integer> iterator = alive.iterator();
		while(iterator.hasNext()) {
			int i = iterator.next();

			int r = sharks[i].r;
			int c = sharks[i].c;

			if(fishing[r][c] == 0) {
				fishing[r][c] = i;
			}
			else { // 상어가 이미 있다. 
				if(sharks[fishing[r][c]].z < sharks[i].z) {
					sharks[fishing[r][c]] = null;
					toRemove.add(fishing[r][c]);
					fishing[r][c] = i;
				}
				else {
				iterator.remove();
				}
			}
		}
		while(!toRemove.isEmpty()) {
			alive.remove((Integer) toRemove.pop());
		}
	}

	static void move(int idx) {
		// 1:위 2:아래 3:오른쪽 4:왼쪽
		int s = sharks[idx].s;
		int d = sharks[idx].d;
		fishing[sharks[idx].r][sharks[idx].c] = 0;
		int cnt = sharks[idx].s;
		
		for(int i = 0; i < cnt; i ++) {
			int ny = sharks[idx].r + dy[d];
			int nx = sharks[idx].c + dx[d];
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
				switch(d) {
				case 1: d = 2; break;
				case 2: d = 1; break;
				case 3: d = 4; break;
				case 4: d = 3; break;} 
				ny = sharks[idx].r + dy[d];
				nx = sharks[idx].c + dx[d];
			}
			sharks[idx].r = ny;
			sharks[idx].c = nx;
		}
		sharks[idx].d = d;
	}

	static class Shark {
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d; 
			this.z = z;
		}
	}

}
