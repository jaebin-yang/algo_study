package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SW_농작물수확하기_2805_2 {
	static int T, N, sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine());
		
			sum = 0;
			int wide = 0; // center 로부터 얼마나 멀어지나
			int center = N/2;
			int startx, endx;
			
			//위에서부터
			for(int i = 0; i < N; i ++) {
				startx = center - wide;
				endx = center + wide;
				
				char [] temp = br.readLine().toCharArray();
				
				for(int j = startx; j <=endx; j ++) {
					sum+=temp[j] - '0';
				}
				
				// wide 늘리거나 줄이거나
				if(i < center) wide ++;
				else wide --;
			}
			
			System.out.println("#" + t + " " + sum);
			
			
		}
	}

}
