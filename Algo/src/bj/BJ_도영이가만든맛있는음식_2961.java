package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도영이가만든맛있는음식_2961 {

	static int N, min;
	static ingredient[] ingredients;
	static boolean[] select;
	// multiply sour, add bitter
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if(N==1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			min = Math.abs(sour - bitter);
		}else {
			select = new boolean[N];
			ingredients = new ingredient[N];
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sour = Integer.parseInt(st.nextToken());
				int bitter = Integer.parseInt(st.nextToken());

				ingredients[i] = new ingredient(sour, bitter);
			}

			min = Integer.MAX_VALUE;
			subset(0);
		}
		System.out.println(min);

	}

	static class ingredient {
		int sour;
		int bitter;
		ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}

	static void subset(int srcIdx) {

		if(srcIdx == N) {
			int s = 1; int b = 0; int count = 0;
			for(int i = 0; i < N; i ++) {
				if(select[i]) {
					s *= ingredients[i].sour;
					b += ingredients[i].bitter;
					count ++;
				}
			}
			if(count == 0) return;
			min = Math.min(min, Math.abs(s-b));

			return;
		}


		select[srcIdx] = true;
		subset(srcIdx+1);

		select[srcIdx] = false;
		subset(srcIdx+1);

	}

}
