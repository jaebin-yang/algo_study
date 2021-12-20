package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SW_사칙연산유효성검사_1233_2 {

	
	static int N, ans;
	static char[] node;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			for(int t = 1; t <= 10; t ++) {
				N = Integer.parseInt(br.readLine());
				node = new char[N+1];
				
				for(int i = 1; i <= N; i ++) {
					node[i] = br.readLine().split(" ")[1].charAt(0);
				}
				
				// 배열의 맨 끝에서 부터 시작
				int no = N;
				ans = 1;
				
				
				while(no != 1) {
					// 유효하지 않으면 ans = 0하고 break
					if(!isNum(no) || !isNum(no-1) || isNum(no/2)) {  
						ans = 0;
						break;
					}
					node[no/2] = '1';
					
					no -= 2;
				}
				System.out.println("#" + t +  " " + ans);
				
			}
	}
	static boolean isNum(int idx) {
		return Character.isDigit(node[idx]);
	}
	


}
