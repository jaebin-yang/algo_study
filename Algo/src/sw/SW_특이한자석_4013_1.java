package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_특이한자석_4013_1 {
	static int T, K;
	static int[] red;
	static int[][] cogs;
	static boolean[] checked;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			K = Integer.parseInt(br.readLine()); 
			red = new int[5];
			cogs = new int[5][8];
			for(int i = 1; i <= 4; i ++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j ++) {
					cogs[i][j] = Integer.parseInt(st.nextToken());
				}
			}		
			checked = new boolean[5];
			for(int i = 0; i < K; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cog = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				move(cog, dir);
			}

			int result = 0;
			for(int i = 1; i <= 4; i ++) {
				if(cogs[i][red[i]] == 1) {
					switch(i) {
					case 1: result += 1; break;
					case 2: result += 2; break;
					case 3: result += 4; break;
					case 4: result += 8; break;
					}
				}
			}	
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void move(int cog, int dir) {
		checked[cog] = true;
		int next = cog + 1;
		int prev = cog - 1;
		int nextDir = dir == 1 ? -1 : 1;
		if(next < 5 && !checked[next]) { 
			int currIdx = (red[cog] + 2) % 8;
			int nextIdx = red[next] - 2;
			if(nextIdx < 0) nextIdx = 8 + nextIdx;
			if(cogs[cog][currIdx] != cogs[next][nextIdx]) {
				move(next, nextDir);
			}
		}
		if(prev > 0 && !checked[prev]) {
			int currIdx = red[cog] - 2;
			if(currIdx < 0) currIdx = 8 + currIdx;
			int prevIdx = (red[prev] + 2) % 8;
			if(cogs[cog][currIdx] != cogs[prev][prevIdx]) {
				move(prev, nextDir);
			}
		}
		
		rotate(cog, dir);
		checked[cog] = false;
		
	}
	
	static void rotate(int cog, int dir) {
		int rotate = red[cog] + (-1)*dir;
		if (rotate < 0) rotate = 8 + rotate;
		if  (rotate > 7) rotate = 0; 
		red[cog] = rotate;
	}

}
