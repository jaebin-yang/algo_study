package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// np 를 이용한 순열 + memoi
// 순서가 뒤 바뀌는 순열의 경우의 수는 매우 많지만, 두 지점의 거리는 반복되어 계산되므로 미리 계산해 두고 이를 이용한다.
public class SW_최적경로_1247_NP_MEMOI {
	
	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] customer, distance;
	static int[] index;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());; // 고객수
			
			customer = new int[N+2][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			customer[0][0] = Integer.parseInt(st.nextToken());
			customer[0][1] = Integer.parseInt(st.nextToken());
			customer[N+1][0] = Integer.parseInt(st.nextToken());
			customer[N+1][01] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			distance = new int[N+2][N+2];
            for(int i=0; i<N+2; i++){
                for(int j=0; j<N+2; j++){
                    if(i != j){
                        distance[i][j] = Math.abs(customer[i][0] - customer[j][0]) + Math.abs( customer[i][1] -  customer[j][1]);
                    }
                }
            }
            
			// np 를 위한 index 배열 생성
			// 모든 고객을 방문하므로 전체를 
			// 0-1-2-3-4 -- 0-1-2-4-3 ........ 4-3-2-1-0
			index = new int[N];
			for (int i = 0; i < N; i++) {
				index[i] = i+1; 
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
		int sum = distance[0][index[0]];

		// 고객 --> 고객
		for (int i = 0; i < N-1; i++) {
			if( sum > min ) return; // 가지치키 코드인데 많이 줄일까??? 이것으로 save 되는 부분은 많아봤자 N 개 // perm() 재귀호출과 다르다.
			sum += distance[index[i]][index[i+1]];
		}
		
		// 고객 마지막 --> 집
		sum += distance[N+1][index[N-1]];

		min = Math.min(min, sum);
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
