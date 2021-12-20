package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_쿼드트리_1992 {

	static int N;
	static char[][] map; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		divide(0, 0, N);
	}

	static void divide(int y, int x, int n) {
		// 하나의 숫자로 이루어져 있는지 체크
		// 하나의 통일된 숫자가 아니라면
		if( ! check(y, x, n) ) {
			
			System.out.print("(");
			int half = n / 2;
			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);
			System.out.print(")");
		}
		
	}
	
	static boolean check(int y, int x, int n) {
		char ch = map[y][x];
		// 모두 같지는 않다.
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if( ch != map[i][j] ) {
					return false;
				}
			}
		}
		
		// 모두 같다.
		System.out.print(ch);
		return true;
	}
}












