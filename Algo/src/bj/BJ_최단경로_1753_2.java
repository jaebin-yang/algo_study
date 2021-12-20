package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최단경로_1753_2 {
	
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> vertex;
	static int[] costs;
	static boolean[] visited;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>((a, b) -> a.cost - b.cost);
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		costs = new int[V+1]; // 0 placeholder
		visited = new boolean[V+1]; 
	
		
		vertex = new ArrayList<ArrayList<Edge>>();
		
		for(int i = 0; i <= V; i ++) {
			vertex.add(new ArrayList<Edge>());
			costs[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			vertex.get(v1).add(new Edge(v2, cost));
		}
		
		costs[K] = 0;
		pqueue.offer(new Edge(K, 0));
		dijkstra();
		
		for(int i = 1; i <= V; i ++) {
			if(costs[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(costs[i]);
			
		}
		
		
	}
	
	static void dijkstra() {
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			if(visited[e.v]) continue;
			visited[e.v] = true;
			
			for(Edge next: vertex.get(e.v)) {
				if(costs[e.v] + next.cost < costs[next.v]) {
					costs[next.v] = costs[e.v] + next.cost;
//					pqueue.offer(new Edge(next.v, costs[next.v]));
					pqueue.offer(next);
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
			return "Edge [v=" + v + ", cost=" + cost + "]";
		}
		
		
	}
 }
