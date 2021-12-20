package basic;

import java.util.Arrays;

public class BASIC_Subset {

	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5};
	// 순열처럼 현재 구성의 이전 사용여부를 체크 X
	// 부분집합을 표현하는 자료구조
	static boolean[] select = new boolean[src.length]; 


	
	public static void main(String[] args) {
		subset(0);
		System.out.println(COUNT);

	}
	static void subset(int srcIdx) {

		
		// 기저조건
		if(srcIdx == src.length) {
			// complete code
			// 부분집합이 하나 완성!!
			printSubset();
			COUNT ++;
			return;
		}
		// 선택
		select[srcIdx] = true;
		subset(srcIdx+1);
		
		// 비선택
		select[srcIdx] = false;
		subset(srcIdx+1);
		
	}
	
	static void printSubset() {
		for(int i = 0; i < select.length; i ++) {
			if(select[i]) System.out.print(src[i] + " "); 
		}
		System.out.println();
	}
}
