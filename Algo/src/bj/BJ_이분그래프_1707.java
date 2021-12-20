package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_이분그래프_1707 {

	static int K, V, E;
	static ArrayList<Node> nodes;
//	static boolean[] visited;
	static boolean result;
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());


		for(int k = 0; k < K; k ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			nodes = new ArrayList<Node>();
			queue.clear();
//			visited = new boolean[V+1]; 
			nodes.add(null); // index 0 is placeholder
			for(int i = 1; i <= V; i ++) {			
				nodes.add(new Node(i));
			}

			// add edges
			for(int i = 0; i < E; i ++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				nodes.get(v1).n.add(v2);
				nodes.get(v2).n.add(v1);
			}


			queue.add(1);
//			visited[1] = true;
			nodes.get(1).label = 1;
			result = true;

			int count = 0;
			while(!queue.isEmpty() && result) {
				int curr = queue.poll();
				Node temp = nodes.get(curr);
				for(int i = 0; i < temp.n.size(); i ++) {
					int next = temp.n.get(i);
					if(temp.label == nodes.get(next).label) {
						result = false; break;
					}
					if(nodes.get(next).label == -1) {
						int nextLabel = temp.label == 1 ? 0 : 1;
						nodes.get(next).label = nextLabel;
//						visited[next] = true;
						queue.add(next);
					}
				}
				count ++;
				if(queue.isEmpty() && count != V) {
					for(int i = 1; i <= V; i ++) {
						if(nodes.get(i).label == -1) {
							nodes.get(i).label = 1;
							queue.offer(i); break;
						}
					}
				}
			}

			String yn = result ? "YES" : "NO";
			System.out.println(yn);



		}
	}

	static class Node {
		int idx, label; // label: 0, 1 (no label: -1)
		ArrayList<Integer> n;
		public Node(int idx) {
			this.idx = idx;
			label = -1;
			n = new ArrayList<Integer>();
		}

	}

}
