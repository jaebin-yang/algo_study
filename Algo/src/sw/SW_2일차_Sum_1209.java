package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2일차_Sum_1209 {

	static int Max;
	static int[][] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t ++) {
			br.readLine();
			numbers = new int[100][100];
			for(int i = 0; i < 100; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j ++) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Max = Integer.MIN_VALUE;
			int sum = 0;
			// 가로
			for(int i = 0; i < 100; i ++) {
				sum = 0;
				for(int j = 0; j < 100; j ++) {
					sum+=numbers[i][j];
				}
				if(sum > Max) Max = sum;
			}
			
			// 세로
			for(int i = 0; i < 100; i ++) {
				sum = 0;
				for(int j = 0; j < 100; j ++) {
					sum+=numbers[j][i];
				}
				if(sum > Max) Max = sum;
			}
			
			// 대각선 오른쪽으로
			sum = 0;
			for(int i = 0; i < 100; i ++) {
				sum+=numbers[i][i];
			}
			if(sum > Max) Max = sum;
			
			// 대각선 왼쪽으로
			sum = 0;
			for(int i = 0; i < 100; i ++) {
				sum+=numbers[i][99-i];
			}
			if(sum > Max) Max = sum;
			
			System.out.println("#" + t + " " + Max);
			
		}

	}

}
