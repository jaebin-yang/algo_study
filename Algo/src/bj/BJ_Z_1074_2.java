package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1  2
// 3  4
public class BJ_Z_1074_2 {
	static int N, r, c, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로, 세로 X 2^N
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N); // N : 3 ==> 8

		z(0, 0);
		
		System.out.println(ans);
	}
	
	static void z(int y, int x) {
		
		if( N == 1 ) return;
		
		N /= 2;
		
		if( r < y + N && c < x + N ) { // 1영역
			z(y, x);
		}else if( r < y + N && c >= x + N ) { // 2영역
			ans += N*N*1; // 해당 영역 전영역까지를 미리 계산
			z(y, x + N);
		}else if( r >= y + N && c < x + N ) { // 3영역
			ans += N*N*2;
			z(y + N, x);
		}else { // 4영역
			ans += N*N*3;
			z( y + N, x + N);
		}
	}

}





