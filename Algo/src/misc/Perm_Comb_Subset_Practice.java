package misc;

import java.util.Arrays;

public class Perm_Comb_Subset_Practice {

	static int COUNT = 0;
	static int[] src = {1,2,3, 4, 5};
	static int[] tgt = new int[3];
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
//		// Basic Perm		
//		perm(0);
//		System.out.println(COUNT);
		
//		// BASIC_Comb_FOR
//		combFOR(0,0);
//		System.out.println(COUNT);
		
//		// BASIC_COMB_RC
//		combRC(0,0);
//		System.out.println(COUNT);
		
		// BASIC_Subset
		subset(0);
		System.out.println(COUNT);
	}
	
	
	
	
	
	
	
	
	
	static void perm(int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT ++;
			return;
		}
		
		for(int i = 0; i < src.length; i ++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	
	static void combFOR(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			//complete code
			System.out.println(Arrays.toString(tgt));
			COUNT ++;
			return;
		}
		
		for(int i = srcIdx; i < src.length; i ++) {
			tgt[tgtIdx] = src[i];
			combFOR(i+1, tgtIdx + 1);
		}
	}
	
	static void combRC(int srcIdx, int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) {
			// complete code!
			System.out.println(Arrays.toString(tgt));
			COUNT ++;
			return;
		}
		
		// 기저조건
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		// Yes
		combRC(srcIdx + 1, tgtIdx + 1);
		// No
		combRC(srcIdx + 1, tgtIdx);
	}
	
	static void subset(int srcIdx) {
		// 기저조건
		if(srcIdx == src.length) {
			printSubset();
			COUNT ++;
			return;
		}
		
		//선택
		select[srcIdx] = true;
		subset(srcIdx+1);
		//비선택
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
