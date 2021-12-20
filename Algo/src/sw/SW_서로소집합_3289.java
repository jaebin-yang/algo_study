package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_서로소집합_3289 {
	static int T, N, M;
//	static Node[] nodes;
	
	static int[] nodes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();

			nodes = new int[N + 1]; 

			for(int i = 0; i <= N; i ++) {
				makeSet(i);
			}

			for(int i = 0; i < M; i ++) {
				st = new StringTokenizer(br.readLine());
				// 0 일떄 합집합
				// 1 일때 같은 집합에 포함되어있는지 확인.
				int operation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if(operation == 0) {
					union(a,b);
				}
				else if(operation == 1) {
					if(findSet(a) == findSet(b)) {
						sb.append("1"); continue;
					}
					sb.append("0");
					
				}
			}
			
			System.out.println("#" + t + " " + sb.toString());
		}

	}

	static int findSet(int idx) {

		if(nodes[idx] == idx) return idx;
		
		return findSet(nodes[idx]);
	}

	static void makeSet(int idx) {
		nodes[idx] = idx;
	}

	static void union(int a, int b) {

			int x = findSet(a);
			int y = findSet(b);
			if(x==y) {
				return;
			}
			if(x > y) {
				nodes[y] = x;
			}
			else {
				nodes[x] = y;
			}
		
		
		return;
	}



}
