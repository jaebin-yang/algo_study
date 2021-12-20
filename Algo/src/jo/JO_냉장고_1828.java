package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_냉장고_1828 {
	static int N, count, max; // count : 냉장고 수, max : 최고 온도
	static int[][] input; // input[i][0] : 최저, input[i][1] : 최고
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(input, (o1, o2)->o1[1]-o2[1]); // asc 최고
		
		// 초기값
		max = Integer.MIN_VALUE;
		count = 0;
		for (int i = 0; i < N; i++) { // i 번째의 최저가 max보다 크면 기존 냉장고 대신 새로운 냉장고가 필요함 
			if(input[i][0] > max) {
				count ++;
				max = input[i][1];
			}
		}
		
		
		System.out.println(count);
	}

}
