package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124 {

	static int T, V, E;
	static ArrayList<Edge> edges;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<Edge>();
			
			for(int i = 0; i < E; i ++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(start, end, weight));
			}
		}
		
		Collections.sort(edges, (a, b) -> a.weight - b.weight);
		
		for(Edge e: edges) {
			System.out.println(e);
		}
		
		
		int count = 0;
		int edgeCount = 0;
		
//		while(count < V - 1) {
//			
//		}
		
		
		

	}
	
	static class Edge {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.start = start; 
			this.end = end;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
		
		
	}

}
