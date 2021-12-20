package sw;


import java.util.Scanner;

public class SW_최장증가부분수열_3307 {

	static int T, N;
	static int[] Array;
	static int[] LIS;
	static int maxLength;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int t = 1; t <= T; t ++) {
			N = sc.nextInt();

			Array = new int[N];
			LIS = new int[N];
			maxLength = 0;

			for(int i = 0; i < N; i ++) {
				int curr = sc.nextInt();
				Array[i] = curr;
				if(i == 0) {
					LIS[i] = 1;
				}
				else {
					int maxIdx = -1;
					for(int j = i-1; j >= 0; j --) {

						if(Array[j] < Array[i]) {
							if(maxIdx == -1) {
								maxIdx = j;
								continue;
							}
							if(LIS[j] > LIS[maxIdx]) {
								maxIdx = j;
							}
						}
					}
					if(maxIdx == -1) LIS[i] = 1; 
					else { LIS[i] = LIS[maxIdx]+1; }
				}
				if(LIS[i] > maxLength) maxLength = LIS[i];
			}

			System.out.println("#" + t + " " + maxLength);



		}


		sc.close();

	}


}
