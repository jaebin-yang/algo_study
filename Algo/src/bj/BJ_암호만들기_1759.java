package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_암호만들기_1759 {
	
	static int L, C;
	static char[] src;
	static char[] tgt;
	static boolean[] isMo; // 모음 구분
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		src = new char[C]; // 주어진 문자의 배열
		tgt = new char[L]; // 암호의 길이
		isMo = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			src[i] = st.nextToken().charAt(0);
		}
		
		// 풀이
		// src 를 정렬 한 후 조합
		Arrays.sort(src);
		
		for (int i = 0; i < C; i++) {
			if( src[i] == 'a' ||src[i] == 'e' ||src[i] == 'i' ||src[i] == 'o' ||src[i] == 'u' ) {
				isMo[i] = true;
			}
		}
		
		comb(0, 0, 0, 0);
	}

	static void comb(int srcIdx, int tgtIdx, int moCnt, int jaCnt) {
		// 기저조건
		if( tgtIdx == L ) {
			// complete code
			if( moCnt >= 1 && jaCnt >= 2 ) {
				print();
			}
			return;
		}
		// 기저조건
		if( srcIdx == C ) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		if( isMo[srcIdx] ) { // 현재 선택한 문자가 모음이면
			comb(srcIdx + 1, tgtIdx + 1, moCnt + 1, jaCnt);
		}else { // 자음이면
			comb(srcIdx + 1, tgtIdx + 1, moCnt, jaCnt + 1);
		}
		
		// 현재 선택을 버리는 경우
		comb(srcIdx + 1, tgtIdx,  moCnt, jaCnt);
	}
	
	static void print() {
		for (int i = 0; i < L; i++) {
			System.out.print(tgt[i]);
		}
		System.out.println();
	}
}








