package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사칙연산유효성검사_1233 {
	static int T = 10;
	static int N, height, index, currHeight, result;
	static StringTokenizer st;
	static boolean calculable;
	static char curr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1233.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());

			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken());
				curr = st.nextToken().charAt(0);

				calculable = true;
				if(st.hasMoreTokens()) {
					if(curr == '*' || curr == '/' || curr == '-' || curr == '+') continue;
					else {
						calculable = false;
//						break;
					}
				}
				else {
					if(curr == '*' || curr == '/' || curr == '-' || curr == '+') {
						calculable = false;
//						break;
					}
					else {
						continue;
					}
				}			
			}
			
			result = calculable?1:0;
			System.out.print("#" + t + " " + result);
			System.out.println();
			
		}
		
		
	}
	


}
