package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_요세푸스문제_1158 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i ++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 1; i < K; i ++) {
				queue.offer(queue.poll());
			}
			result.offer(queue.poll());
		}
		

		String answer = result.toString();
		answer = answer.substring(1, answer.length()-1);
		System.out.println("<" + answer + ">");
		
		
		
		
	}
	
	

}
