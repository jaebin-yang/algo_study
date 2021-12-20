package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// np 를 이용한 순열
public class SW_최적경로_1247_NP {
	
	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] customer;
	static int[] index;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());; // 고객수
			
			customer = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// np 를 위한 index 배열 생성
			// 모든 고객을 방문하므로 전체를 
			// 0-1-2-3-4 -- 0-1-2-4-3 ........ 4-3-2-1-0
			index = new int[N];
			for (int i = 0; i < N; i++) {
				index[i] = i; 
			}

			while(true) {
				
				go();
				
				if( ! np() ) break;
			}
			
			System.out.println("#" + t + " " + min);
		}

	}
	
	// 순열이 완성된 상태에서 실행
	static void go() {

		// 회사 --> 고객 첫번째
		int sum = distance(
						comY, comX, 
						customer[index[0]][0], customer[index[0]][1]
					);
		// 고객 --> 고객
		for (int i = 0; i < N - 1; i++) {
			if( sum > min ) return; // 이것이 과연 가지치기일까
			sum += distance(
							customer[index[i]][0], customer[index[i]][1], 
							customer[index[i+1]][0], customer[index[i+1]][1]
						);
		}
		
		// 고객 마지막 --> 집
		sum += distance(
					customer[index[N-1]][0], customer[index[N-1]][1], 
					homeY, homeX
				);
		min = Math.min(min, sum);
	}
	
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}
	
	static boolean np() {
		
		int i = index.length -1;		
		while( i>0 && index[i-1] >= index[i] ) i--;
		
		if( i == 0 ) return false;
		
		int j = index.length -1;
		while( index[i-1] >= index[j]) j--;
		
		swap( index, i-1, j);
		
		int k = index.length -1;
		while( i<k ) swap( index, i++, k--);
		
		return true;
	}
	
	static void swap(int[] array, int i, int j ) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
