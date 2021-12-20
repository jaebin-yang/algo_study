package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124_K {

	static int T, V, E;
	static long sum;
	static int[] parent;
	
	static Edge[] edges;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			sum = 0;
			parent = new int[V+1];
			edges = new Edge[E];
			
			// 간선
			for(int i = 0; i < E; i ++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(v1, v2, c);
			}
			
			makeSet();
			// 간선 정렬
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
			
			// 작은 것부터 => 맨 앞부터
			int cnt = 0; // 간선의 개수
			for(int i = 0; i < E; i ++) {
				Edge edge = edges[i];
				// 이 간선이 연결하는 두개의 정점이 이미 연결되어 있는지 확인
				if(findSet(edge.v1) == findSet(edge.v2)) continue;
				union(edge.v1, edge.v2);
				cnt ++; // 선택된 간선의 개수
				sum += edge.c; // 선택된 비용의 누적 값
				
				if(cnt == V-1) break;
			}
			
			System.out.println("#" + t + " " + sum);
		}

	}
	
	static void makeSet() {
		for(int i = 1; i <= V; i ++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if(px < py) parent[py] = px;
		else parent[px] = py;

	}
	
	static class Edge{
		int v1;
		int v2;
		int c;
		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}

}
