package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_사칙연산유효성검사_1233_1 {
	static int T = 10;
	static int N, height, index, currHeight, result;
	static StringTokenizer st;

	static char[] tree;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1233.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N];
			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken());

				tree[N] = st.nextToken().charAt(0);	
			}
			result = 1;
			for(int i = 0; i < N; i ++) {
				
			}
			

			System.out.print("#" + t + " " + result);
			System.out.println();
			
		}
		
		
	}
	


}
