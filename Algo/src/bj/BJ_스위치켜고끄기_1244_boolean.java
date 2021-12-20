package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스위치켜고끄기_1244_boolean {

	static int N, COUNT;
	static boolean[] switches;
	static int gender, num; // 로컬
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N+1]; // 0 dummy
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			//switches[i] = Integer.parseInt( st.nextToken() );
			//switches[i] = st.nextToken().charAt(0) - '0';
			//if( Integer.parseInt( st.nextToken() )  == 1 ) switches[i] = true;
			if( st.nextToken().equals("1") ) switches[i] = true;
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
			System.out.print(switches[i] ? 1 : 0 );
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
			switches[i] = !switches[i];
		}
	}
	
	
	static void female() {
		// 현재 자기 부여 번호 자리
		switches[num] = !switches[num];
		int cnt = 1; // 양 옆으로 움직이는 범위
		while( num-cnt >= 1 && num+cnt <= N ) { // 범위 체크
			if( switches[num-cnt] == switches[num+cnt] ) {
				switches[num-cnt] = !switches[num-cnt];
				switches[num+cnt] = !switches[num+cnt];
			}else {
				break;
			}
			cnt++;
		}
	}
	
	
	
	
}
