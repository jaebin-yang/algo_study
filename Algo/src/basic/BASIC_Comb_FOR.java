package basic;

import java.util.Arrays;

public class BASIC_Comb_FOR {

	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5};
	static int[] tgt = new int [3];


	
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(COUNT);

	}
	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건
		if(tgtIdx == tgt.length) {
			// complete code!!
			// 순열 하나 완성! = 문제에 맞는 추가 작업
			System.out.println(Arrays.toString(tgt));
			COUNT ++;
			return;
		}
		
		// src 로부터 모든 수를 고려 단, 이미 선택된 숫자는 제외
		for(int i = srcIdx; i < src.length; i ++) {
			
			
			tgt[tgtIdx] = src[i];

			comb(i + 1, tgtIdx + 1);

		}
	}
}
