package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_구간합_5604 {

	static int T;
	static long A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			long result = 0;
			
			if(A == B) {
			 
			}
			else {
				// 자릿수 구하기
				long numA = (long) Math.log10(A) + 1;
				long numB = (long) Math.log10(B) + 1;
				
				// 자릿수가 달라질 때;
				if(numB > numA) {
					
				}
			}
			
			System.out.println("#" + t + " " + result);
		}

	}

}
