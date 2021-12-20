package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_원점으로집합_8458 {

	static int T, N, max;
	static int[] point; // 점(거리)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N];
			
			// 첫번쨰
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[0] = Math.abs(x) + Math.abs(y);
			
			max = point[0];
			//두번째 ~ 나머지
			boolean stop = false;
			for(int i = 1; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				point[i] = Math.abs(x) + Math.abs(y);
				max = Math.max(max, point[i]);
				
				if(point[i] % 2 != point[i-1] %2) {
					
					stop = true;
				}
			}
			// 이전것과 짝수 홀수 비교
			if(stop) {
				System.out.println("#" + t + " -1");
				continue;
			}
			
			// 가장 긴 거리 - 원점 사이의 간격을 1 + 2 + 3 + .... 원점과 만나거나
			// 안 만나는 경우, 그 지나간 (초과한) 차이가 짝수이면 된다. 
			int sum = 0; // 1 + 2 + 3....
			int cnt = 0; // 1 -> 2 -> 3 : 횟수
			
			while(true) {
				if(sum >= max && (sum - max) % 2 == 0) break;
				sum += ++ cnt;
			}
			
			System.out.println("#" + t + " " + cnt);
		}

	}

}
