package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;





public class BJ_최단경로_1753 {


	static int V, E, K;
	static boolean [] visited;
	static int[] weights;

	static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1, e2) -> e1.cost - e2.cost);
	
	
	
	static ArrayList<ArrayList<Edge>> vertex;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visited = new boolean[V+1]; // 0 is dummy
		weights = new int[V+1];

		Arrays.fill(weights, Integer.MAX_VALUE);
		
		vertex = new ArrayList<ArrayList<Edge>>();

		for(int i = 0; i <= V; i ++) {
			vertex.add(new ArrayList<Edge>());
		}


		for(int i = 0; i < E; i ++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			vertex.get(v1).add(new Edge(v2, cost));
		}
		



		weights[K] = 0;
		dijkstra();

		for(int i = 1; i < V+1; i ++) {
			if(weights[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(weights[i]);
		}


	}


	static void dijkstra() {
		pqueue.offer(new Edge(K, 0));
		while(!pqueue.isEmpty()) {
			Edge pe = pqueue.poll();
			if(visited[pe.v]) continue;
			visited[pe.v] = true;
			

			for(Edge e: vertex.get(pe.v)) {
				if(!visited[e.v]) {
				if(weights[pe.v] + e.cost < weights[e.v]) {
					weights[e.v] = weights[pe.v] + e.cost;
					pqueue.offer(new Edge(e.v, weights[e.v]));
				}
				
				}
			}


		}
	}

	static class Edge {

		int v;
		int cost;

		public Edge(int v, int cost) {
			this.v = v;

			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v + ", cost=" + cost + "]";
		}


	}

}
