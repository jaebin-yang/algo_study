package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_요세푸스_1158_2 {
	
	static int N, K;
	static int[] input;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}
		
		output.append("<");
		
		int step = 1; // 살아있는 번호에만 증가
		int count = 0; // 죽는 숫자의 숫자
		int idx = 1; // input 의 index
		// 죽는 번호는 0으로 변경
		while( true ) {
			if( count == N ) break;
			// 살아있는 번호
			if( input[idx] != 0 ) {
				// 그 번호가 K 의 배수이면
				if( step % K == 0 ) {
					output.append(input[idx] + ", ");
					input[idx] = 0;
					count++;
				}
				step++;
			}
			
			idx++;
			if( idx > N ) idx = 1;
		}
		
		output.deleteCharAt(output.length()-2);
		output.deleteCharAt(output.length()-1);
		output.append(">");
		System.out.println(output);
	}

}
