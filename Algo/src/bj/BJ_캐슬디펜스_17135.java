package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_캐슬디펜스_17135 {

	static int N, M, D, maxKill, count;
	static Archer ArcherX;
	static List<Enemy> enemies = new ArrayList<>();
	static List<Enemy> toKill = new ArrayList<>();
	static Archer[] archers = new Archer[3];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		enemies = new ArrayList<>();
		maxKill = Integer.MIN_VALUE;
		for(int i = 0; i < N; i ++) {			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				if(st.nextToken().charAt(0) == '1') {
					enemies.add(new Enemy(i, j));
				}
			}
		}
		
		comb(0, 0);

		System.out.println(maxKill);

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) { 
			for(Enemy e : enemies) {
				e.isAlive = true;
			}
			

			int destroyed = runSimulation();

			maxKill = Math.max(destroyed, maxKill);

			return;
		}
		if(srcIdx == M) return;
		archers[tgtIdx] = new Archer(srcIdx);
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);	
	}
	
	
	

	static int runSimulation() {
		int destroyed = 0;
		count = 0;
		while(count < N) {
			for(Enemy e : enemies) {
				if(e.y + count == N) e.isAlive = false;
			}
			toKill.clear();
			for(int i =0 ; i < 3 ; i ++) {
				ArcherX = archers[i];
				Collections.sort(enemies);					
					if(getDistance(archers[i], enemies.get(0)) <= D) {
						toKill.add(enemies.get(0));
					}				
			}
			
			for(Enemy e : toKill) {
				if(e.isAlive) {
					e.isAlive = false;
					destroyed++;
				}
				
			}
			count ++;
		}
		return destroyed;		
	}
	
	

	
	static class Archer {
		int x, y;
		Enemy target;
		Archer(int x) {
			this.x = x;
			this.y = N;
		}
		
		Archer() {
			this.x = 0;
			this.y = N;
		}
		

	}
	
	static int getDistance(Archer a, Enemy e) {
		if(e.y+count >= a.y) return Integer.MAX_VALUE;
		return Math.abs(a.x - e.x) + Math.abs(a.y - (e.y+count));
	}
	
	static class Enemy implements Comparable<Enemy> {
		boolean isAlive;
		int y;
		int x;
		Enemy(int y, int x) {
			this.isAlive = true;
			this.y = y;
			this.x = x;
		}
		

		


		@Override
		public int compareTo(Enemy e) {
			int d1 = getDistance(ArcherX, this);
			int d2 = getDistance(ArcherX, e);		
			
			if(this.isAlive && e.isAlive) {
				if(d1 == d2) {
					return this.x - e.x;
				}
				else {
					return d1 - d2;
				}
			}
			else {
				if(this.isAlive && !e.isAlive) return -1;
				else if(!isAlive && e.isAlive) return 1;
				else return d1 - d2;
			}


		}
	}

}
