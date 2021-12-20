package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215 {
	static int T, N, L, Max;
	static int[] score, kcal;
	static boolean[] select;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_5215.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			kcal =  new int[N];
			select = new boolean[N];
			Max = 0;
			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			//			subset(0);
			subset(0, 0);

			System.out.println("#" + t + " " + Max);		
		}

	}

	static void subset(int srcIdx, int currCal) {
		if(currCal > L) return;
		if(srcIdx == N) {
			int temp = 0;
			for(int i = 0; i < N; i ++) {
				if(select[i]) {
					temp += score[i];
				}
			}
			Max = Math.max(temp, Max);				
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1, currCal + kcal[srcIdx]);

		select[srcIdx] = false;
		subset(srcIdx+1, currCal);
	}








}
