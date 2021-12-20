package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_하나로_1251_KRUSKAL {
	static int T, N;
	static double E, sum;
	static int [][] island;
	static int [] edgeComb;
	static int [] parent;
	static ArrayList<Edge> edges;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());

			island = new int[N+1][2];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());
			for(int i = 1; i < N+1; i ++) {	
				island[i][0] = Integer.parseInt(st1.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}


			edges = new ArrayList<Edge>();
			parent = new int[N+1];
			edgeComb = new int[2];

			makeSet();

			combEdges(1, 0);
			Collections.sort(edges, (e1, e2) -> Double.compare(e1.cost,e2.cost));

			sum = 0.0;
			int cnt = 0;
			for(int i = 0; i < edges.size(); i ++) {
				Edge edge = edges.get(i);

				if(findSet(edge.v1) == findSet(edge.v2)) continue;
				union(edge.v1, edge.v2);
				cnt ++;
				sum += edge.cost;

				if (cnt == N ) break;
			}

			System.out.println("#" + t + " " + Math.round(sum));
		}

	}

	static void makeSet() {
		for(int i = 1; i < N+1; i ++) {
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



	static void combEdges(int src, int tgt) {
		if(tgt == 2) {
			double x = (double) Math.pow((island[edgeComb[0]][0] - island[edgeComb[1]][0]), 2);
			double y = (double) Math.pow((island[edgeComb[0]][1] - island[edgeComb[1]][1]), 2);
			edges.add(new Edge(edgeComb[0], edgeComb[1], (x+y) * E));

			return;
		}
		if(src == N + 1) return;

		edgeComb[tgt] = src;
		combEdges(src+1, tgt+1);
		combEdges(src+1, tgt);

	}



	static class Edge {
		int v1; 
		int v2; 
		double cost;

		public Edge(int v1, int v2, double cost) {
			this.v1 = v1; 
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", cost=" + cost + "]";
		}


	}

}
