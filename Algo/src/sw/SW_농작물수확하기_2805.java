package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_농작물수확하기_2805 {
	static int N;
	static int [][] farm;
	static int sum;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			farm = new int [N][N];
			
			for(int i = 0; i < N; i ++) {
				String indices = br.readLine();
				for(int j = 0; j < N; j ++) {
					farm[i][j] = indices.charAt(j) - '0';
				}
			}
			
			sum = 0;
			int middleIndex = N / 2;
			int addOn = 0;
			for(int i = 0; i < N; i ++) {
				
				for(int j = middleIndex - addOn; j <= middleIndex + addOn; j ++) {
					sum += farm[i][j];
				}
							
				addOn = (i < middleIndex) ? ++addOn : --addOn ;
				
		
				
			}		
			System.out.println("#" + test_case + " " + sum);

		}
	}

}
