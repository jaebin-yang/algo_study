package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_원재의메모리복구하기_1281_2 {

	static int T;
	static char[] input, memory;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			int count = 0;
			input = br.readLine().toCharArray();
			int cnt = input.length;
			char current = '0';
			
			for(int i = 0; i < cnt; i ++) {
				if(memory[i] != input[i]) {
					count ++;
					current = input[i];
				}
			}
			
			
			
			
			System.out.println("#" + t + " " + count);
		}
		



	}

}
