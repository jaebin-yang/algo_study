package basic;

import java.util.Arrays;

public class BASIC_Perm {

	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3};
	static int[] tgt = new int [3];
	static boolean[] select = new boolean[src.length];
	
	
	// 중복순열X
	// 중복 허용X
	// 1, 2, 3
	// 2, 3, 1
	
	
	public static void main(String[] args) {
		perm(0);
		System.out.println(COUNT);

	}
	static void perm(int tgtIdx) {
		// 기저 조건
		if(tgtIdx == tgt.length) {
			// complete code!!
			// 순열 하나 완성! = 문제에 맞는 추가 작업
			System.out.println(Arrays.toString(tgt));
			COUNT ++;
			return;
		}
		
		// src 로부터 모든 수를 고려 단, 이미 선택된 숫자는 제외
		for(int i = 0; i < src.length; i ++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
}
