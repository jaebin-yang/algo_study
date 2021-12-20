package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class SW_하나로_1251_PRIM {
	static int T, N;
	static double E, sum;
	static int [][] island;


	static ArrayList<ArrayList<Edge>> vertex;
	static boolean[] visit;
	static PriorityQueue<Edge> queue = new PriorityQueue<Edge>((e1, e2) -> Double.compare(e1.cost,e2.cost));
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());

			island = new int[N][2];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());
			for(int i = 0; i < N; i ++) {	
				island[i][0] = Integer.parseInt(st1.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
				
				vertex = new ArrayList<ArrayList<Edge>>();
				for(int j = 0; j < N; j ++) {
					vertex.add(new ArrayList<Edge>());
				}
			}
			sum = 0;

			visit = new boolean[N];
			
			// 간선
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					if(i != j) {
						double x = (double) Math.pow((island[i][0] - island[j][0]), 2);
						double y = (double) Math.pow((island[i][1] - island[j][1]), 2);
						
						double cost = (x + y) * E;
						vertex.get(i).add(new Edge(j, cost));
						vertex.get(j).add(new Edge(i, cost));
					}
				}
			}
			
			queue.clear();
			int cnt = 0;
			visit[0] = true;
			
			queue.addAll(vertex.get(0));
			while(!queue.isEmpty()) {
				Edge edge = queue.poll();
				if(visit[edge.v]) continue;
				
				queue.addAll(vertex.get(edge.v));
				visit[edge.v] = true;
				sum += edge.cost;
				cnt ++;
				if(cnt == N-1) break;
			}

			System.out.println("#" + t + " " + Math.round(sum));
		}

	}





	static class Edge {

		int v; 
		double cost;

		public Edge(int v, double cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", cost=" + cost + "]";
		}


	}

}
