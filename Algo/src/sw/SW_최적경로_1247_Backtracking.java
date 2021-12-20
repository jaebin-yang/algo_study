package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최적경로_1247_Backtracking {
	static int T, N, min;
	// stops 0번: 회사, N+1번: 집
	static int [][] stops;  
	static boolean [] select;
	static int [][] target;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			
			stops = new int[N+2][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			stops[0][0] = y;
			stops[0][1] = x;
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			stops[N+1][0] = y;
			stops[N+1][1] = x;
			
			
			for(int i = 1; i < N + 1; i ++) {
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				
				stops[i][0] = y;
				stops[i][1] = x;
			}
			
			
			select = new boolean[N+2];
			target = new int[N+2][2];
			
			target[0] = stops[0];
			target[N+1] = stops[N+1];
			
			min = Integer.MAX_VALUE;
			
			perm(1, 0);
			System.out.println("#" + t + " " + min);
			
			
		}

	}
	
	static void perm(int tgtIdx, int distance) {
		if(tgtIdx == N+1) {
			min = Math.min(min, distance + getDistance(tgtIdx));
			return;
		}
		for(int i = 1; i < N+1; i ++) {
			if(select[i]) continue;

			target[tgtIdx] = stops[i];
			if(distance + getDistance(tgtIdx) < min) {
				select[i] = true;
				perm(tgtIdx+1, distance + getDistance(tgtIdx));
				select[i] = false;
			}
		}
	}
	
	static int getTotalDistance() {
		int distance = 0;
		for(int i = 0; i < N + 1; i ++) {
			distance += (Math.abs(target[i][0] - target[i+1][0]) +
					Math.abs(target[i][1] - target[i+1][1]));
		}
		return distance;
	}
	
	static int getDistance(int idx) {
		return Math.abs(target[idx][0] - target[idx-1][0]) + Math.abs(target[idx][1] - target[idx-1][1]);
	}
	
	static class Location {
		int y, x;
		Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}

}
