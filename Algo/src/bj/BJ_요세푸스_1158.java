package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_요세푸스_1158 {
	
	static int N, K;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		output.append("<");
		
		int step = 1;
		while( !queue.isEmpty() ) {
			int num = queue.poll();
			
			if( step % K == 0 ) {
				output.append(num + ", ");
			}else {
				queue.add(num);
			}
			
			step++;
		}
		
		output.deleteCharAt(output.length()-2);
		output.deleteCharAt(output.length()-1);
		output.append(">");
		System.out.println(output);
	}

}
