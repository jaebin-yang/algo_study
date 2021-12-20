package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스위치켜고끄기_1244 {

	static int N, COUNT;
	static int[] switches;
	static int gender, num; // 로컬
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		switches = new int[N+1]; // 0 dummy
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			//switches[i] = Integer.parseInt( st.nextToken() );
			switches[i] = st.nextToken().charAt(0) - '0';
		}

		COUNT = Integer.parseInt(br.readLine());
		for (int i = 0; i < COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if( gender == 1 ) {
				male();
			}else if(gender == 2) {
				female();
			}
		}
		
		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i]);
			if( i != N ) {
				if( i% 20 == 0 ) {
					System.out.println();
				}else {
					System.out.print(" ");
				}
			}
		}
		
	}

	static void male() {
		for (int i = num; i <= N; i += num) {			
			switches[i] = switches[i] == 0 ? 1 : 0;
		}
	}
	
	
	static void female() {
		// 현재 자기 부여 번호 자리
		switches[num] = switches[num] == 0 ? 1 : 0;
		int cnt = 1; // 양 옆으로 움직이는 범위
		while( num-cnt >= 1 && num+cnt <= N ) { // 범위 체크
			if( switches[num-cnt] == switches[num+cnt] ) {
				switches[num-cnt] = switches[num-cnt] == 0 ? 1 : 0;
				switches[num+cnt] = switches[num+cnt] == 0 ? 1 : 0;
			}else {
				break;
			}
			cnt++;
		}
	}
	
	
	
	
}
