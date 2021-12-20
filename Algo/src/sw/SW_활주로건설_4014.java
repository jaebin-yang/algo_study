package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_활주로건설_4014 {

	static int T, N, X, result;
	static int[][] area;
	static boolean[]ramp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			area = new int[N][N];
			ramp = new boolean[N];

			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j ++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = 0;

			for(int i = 0; i < N; i ++) {
				boolean canBuild = true;
				ramp = new boolean[N];
				for(int j = 1; j < N; j ++) {
					if(!canBuild) break;
					if(area[i][j-1] == area[i][j]) continue;
					if(area[i][j-1] + 1 == area[i][j]) {
						if(j-X < 0) {
							canBuild = false;
							continue;
						}
						for(int x = 1; x <= X; x ++) {
							if(ramp[j-x] || area[i][j-1] != area[i][j-x]) {
								canBuild = false;
								break;
							}
							ramp[j-x] = true;
						}
					}
					else if (area[i][j-1] == area[i][j] + 1){
						if(j+X-1 >= N) {
							canBuild = false;
							continue;
						}
						for(int x = 0; x < X; x ++) {
							if(ramp[j+x] || area[i][j] != area[i][j+x]) {
								canBuild = false;
								break;
							}
							ramp[j+x] = true;
						}
					}
					else canBuild = false;
				}
				result = canBuild ? result + 1 : result;
			}

			for(int j = 0; j < N; j ++) {
				boolean canBuild = true;
				ramp = new boolean[N];
				for(int i = 1; i < N; i ++) {
					if(!canBuild) break;
					if(area[i-1][j] == area[i][j]) continue;
					if(area[i-1][j] + 1 == area[i][j]) {
						if(i-X < 0) {
							canBuild = false;
							continue;
						}
						for(int x = 1; x <= X; x ++) {
							if(ramp[i-x] || area[i-1][j] != area[i-x][j]) {
								canBuild = false;
								break;
							}
							ramp[i-x] = true;
						}
					}
					else if(area[i-1][j] == area[i][j] + 1){
						if(i+X-1 >= N) {
							canBuild = false;
							continue;
						}
						for(int x = 0; x < X; x ++) {
							if(ramp[i+x] || area[i][j] != area[i+x][j]) {
								canBuild = false;
								break;
							}
							ramp[i+x] = true;
						}
					}
					else canBuild = false;
				}
				result = canBuild ? result + 1 : result;
			}
			
			System.out.println("#" + t + " " + result);
		}

	}

}


