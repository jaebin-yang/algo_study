package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_무선충전_5466 {

	static int T, M, A, ans;
	static int[] pathA, pathB;
	static BC[] bcArray;
	
	static int ay, ax, by, bx;
	
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동시간
			A = Integer.parseInt(st.nextToken());
			
			// 이동경로
			pathA = new int[M];
			pathB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i ++) {
				pathA[i] = st.nextToken().charAt(0) - '0';
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i ++) {
				pathB[i] = st.nextToken().charAt(0) - '0';
			}
			
			// BC 
			bcArray = new BC[A];
			for(int i = 0; i < A; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y, x, c, p);
			}
			
			// 초기화
			ans = 0;
			
			// 초기 위치
			ay = 1; ax = 1; by = 10; bx = 10;
			// 충전
			charge();
			
			// 반복 이동
			for(int i = 0; i < M; i ++) {
				// 이동
				ay += dy[pathA[i]];
				ax += dy[pathA[i]];
				by += dy[pathB[i]];
				bx += dy[pathB[i]];
				// 충전
				charge();
			}
			
			System.out.println("#" + t + " " + ans);
		}

	}
 	
 	static void charge() {
 		int max = 0;
 		// 각각의 BC 한개에 대해서( a 가 )
 		for(int i = 0; i < A; i ++) {
 			for (int j = 0; j < A; j++) { // 각각의 BC 한개에 대해 (b 가)
				int sum = 0;
				int aSum = getPower(bcArray[i], ay, ax); // a가 충전한 파워
				int bSum = getPower(bcArray[j], by, bx); // b가 충전한 파워
				
				
				
				if(i != j) {// 충전소 다른 경우
					sum = aSum + bSum;
				} else {// 충전소가 같은 경우 <== 두 군데에서 모두 충전된다의 의미 X
					// a, b 가 모두 충전 가능
					// aSum/2 bSum/2 => aSum, bSum 두개 중 하나만 선택하면 된다.
					// a, b 중 하나만 충전 가능
					sum = Math.max(aSum, bSum);
				}
				max = Math.max(max, sum);
			}
 		}
 		
 		ans += max;
 	}
 	
 	static int getPower(BC bc, int y, int x) {
 		//  BC 범위 안 확인 => BC p 리턴
 		if(Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c) {
 			return bc.p;
 		}
 		return 0;
 	}
	
	static class BC {
		int y, x, c, p;
		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}

}
