package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_규영이와인영이의카드게임_6808_2_BITMASK {

	static int T, win, lose, N=9;
	static int[] input = new int[19];
	static int[] guCard = new int[9];
	static int[] inCard = new int[9]; // 나머지 카드들 => 순열 경우의 수 => src
//	static int[] tgt = new int[9];
//	
//	static boolean[] select = new boolean[N];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= 4; t++) {
			// 초기화
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 규영이 카드
			for(int i = 0; i<N; i ++) {
				int num = Integer.parseInt(st.nextToken());
				input[num] = 1;
				guCard[i] = num;
			}

			//인영이카드
			int num = 0;
			for(int i = 1; i<=N*2; i ++) {
				if(input[i] == 0) {
					inCard[num++] = i;
				}
			}

			// 입력
			 perm(0, 0, 0,0);
			
			
			// 출력
			 System.out.println("#" + t + " " + win + " " + lose);
		
		}
	}
	
	static void perm(int tgtIdx, int mask, int guSum, int inSum) {
		// 기저조건
		if(tgtIdx == N) {
			// complete code
			if(guSum > inSum) win++;
			else if(guSum < inSum) lose ++;
			return;
		}
		
		for(int i = 0; i < N; i ++) {
//			if(select[i]) continue;
			// 1<<i // 0000010000 & 11011111
			if((mask & 1<<i) != 0) continue;
 			
			

			if(guCard[tgtIdx]>inCard[i]) {
				perm(tgtIdx+1, mask | 1<<i, guSum + guCard[tgtIdx]+inCard[i], inSum);
			} else {
				perm(tgtIdx+1, mask | 1<<i, guSum, inSum +guCard[tgtIdx] +inCard[i]);
			}

		}
	}
	
	static void check() {
		// 인영 카드 순열과 규영 카드 시합
		int guSum = 0;
		int inSum = 0;
		for(int i = 0; i < N; i ++) {
			if(guCard[i] > inCard[i]) guSum += guCard[i] = inCard[i];
			else inSum += guCard[i] = inCard[i];
		}
		if(guSum > inSum) win++;
		else if(guSum < inSum) lose++;
	}

}
