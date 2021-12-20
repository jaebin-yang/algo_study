package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_특이한자석_4013 {
	static int T, K;
	static int[] red;
	static int[][] cogs;
	static boolean[] checked;
	// N극: 0, S극: 1
	// 시계방향: 1, 반시계방향: -1
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			K = Integer.parseInt(br.readLine());
			// red index은 0으로 주어진다. 
			red = new int[5]; // 0 is placeholder
			cogs = new int[5][8]; // 0 is placeholder
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
			
			
			// 점수계산
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
		// 현재 자석의 red-2랑 오른쪽 자석의 red+2 비교
		
		// 다음 자석도 움직이는 것이 가능하면 move부르고
		// return 한 후에 현재 자석을 움직인다.
		checked[cog] = true;
		int next = cog + 1;
		int prev = cog - 1;
		int nextDir = dir == 1 ? -1 : 1;
		if(next < 5 && !checked[next]) { // 현재 자석의 red+2랑 오른쪽 자석의 red-2 비교
			int currIdx = (red[cog] + 2) % 8;
			int nextIdx = red[next] - 2;
			if(nextIdx < 0) nextIdx = 8 + nextIdx;
			if(cogs[cog][currIdx] != cogs[next][nextIdx]) {
				// 다음것도 회전할 수 있다. 
				move(next, nextDir);
			}
		}
		if(prev > 0 && !checked[prev]) { 	// 현재 자석의 red-2랑 오른쪽 자석의 red+2 비교
			int currIdx = red[cog] - 2;
			if(currIdx < 0) currIdx = 8 + currIdx;
			int prevIdx = (red[prev] + 2) % 8;
			if(cogs[cog][currIdx] != cogs[prev][prevIdx]) {
				// 전 것도 회전 가능
				move(prev, nextDir);
			}
		}
		
		rotate(cog, dir);
		checked[cog] = false;
		
	}
	
	static void rotate(int cog, int dir) {
		int rotate = red[cog] + (-1)*dir; // 시계방향으로 움직이면 전 각날 이 빨간색 화살표로 오고
									// 반시계방향으로 움직이면 다음 각날이 빨간색 화살표로 온다. 
		if (rotate < 0) rotate = 8 + rotate;
		if  (rotate > 7) rotate = 0; 
		red[cog] = rotate;
	}

}
