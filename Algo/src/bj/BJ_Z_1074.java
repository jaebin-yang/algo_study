package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z_1074 {

	static int N, r, c;
	static int count = 0, curr = 0, y,x;
	static int [][] array;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		
	}
	
	static int[] dy = {};
	static int[] dx = {};
	public void traverseArray(int n, int i, int j) {
		if(curr == 0) {
			
		}
		else {
			
		}
		
	}
	
	public void getCount(int Nr, int Nc) {
		// 기저조건
		
		if(r > Math.pow(2,  Nr) && r > Math.pow(2,  Nc)) {
			count += Math.pow(2, Nr) * Math.pow(2,  Nc);
		}
		
		
		
		
		
		
		if(r < Math.pow(2, Nr) && c < Math.pow(2, Nc)) {
			getCount(Nr - 1, Nc-1);
			getCount(Nr-1, Nc);
			getCount(Nr, Nc-1);
		}
	}

}
