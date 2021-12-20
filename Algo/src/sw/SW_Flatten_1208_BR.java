package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Flatten_1208_BR {
	static int[] floor;
	static int dump, minIdx, maxIdx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("SW_1208_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
		for(int t = 1; t <= 10; t ++) {
			dump = Integer.parseInt(br.readLine());
			floor = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i ++) {
				floor[i] = Integer.parseInt(st.nextToken());
			}
			
			reset();
			
			for(int i = 0; i < dump; i ++) {
				// 평탄화 완료
				if(floor[maxIdx] - floor[minIdx] == 0 || floor[maxIdx] - floor[minIdx] == 1) break;
				floor[maxIdx] --;
				floor[minIdx] ++;
				reset();
				
			}
			
			int result = floor[maxIdx] - floor[minIdx];
			System.out.println("#" + t + " " + result);
			
		}
		long end = System.nanoTime();
		System.out.println(end - start);
	}
	
	
	// 현재 상태의 floor 기준으로 최대 최소 값ㅇ르 가진 index 계산
	static void reset() {
		for(int i = 0; i < 100; i ++) {
			if(floor[i] < floor[minIdx]) {
				minIdx = i;
			}
			if(floor[i] > floor[maxIdx]) {
				maxIdx = i;
			}
		}
	}

}
