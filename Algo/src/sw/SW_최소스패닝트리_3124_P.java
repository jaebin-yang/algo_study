package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124_P {

	static int T, V, E;
	static long sum;
//	static int[] parent;
	
//	static Edge[] edges;
	static ArrayList<ArrayList<Edge>> vertex; //  정점 리스트
	static boolean[] visit;
	
	static PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1, e2) -> (e1.c - e2.c));
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			sum = 0;
			vertex = new ArrayList<ArrayList<Edge>>();

			for(int i = 0; i <= V; i ++) {
				vertex.add(new ArrayList<Edge>());
			}
			
			visit = new boolean[V+1]; // 0 dummy
			
			// 간선
			for(int i = 0; i < E; i ++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				vertex.get(v1).add(new Edge(v2, c));
				vertex.get(v2).add(new Edge(v1, c));
			}
			
			queue.clear();
			
			int cnt = 1;
			visit[1] = true;
			
			queue.addAll(vertex.get(1));
			while(!queue.isEmpty()) {
				Edge edge = queue.poll(); // 현재 queue 에 담긴 Edge 중 비용이 최소인 것
				if(visit[edge.v]) continue;
				
				queue.addAll(vertex.get(edge.v));
				visit[edge.v] = true;
				sum += edge.c;
				cnt ++;
				if(cnt == V) break;
			}
			System.out.println("#" + t + " " + sum);
		}

	}

	static class Edge{
		int v;
		int c;
		public Edge(int v, int c) {
			this.v = v;

			this.c = c;
		}
	}

}
