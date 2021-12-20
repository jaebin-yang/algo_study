package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS_1260 {

	static int N, M, V;
	static Node [] vertices;
	static boolean [] visited;
	static Queue<Integer> queue;
	static int idx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		vertices = new Node[N + 1];
		visited = new boolean[N+1];
		queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i ++) {
			vertices[i] = new Node(i);
		}
		
		for(int i = 0; i < M; i ++ ) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			vertices[v1].links.add(v2);
			vertices[v2].links.add(v1);

		}

		for(int i = 1; i <= N; i ++) {

				Collections.sort(vertices[i].links, (a, b) -> a - b);

		}



		Arrays.fill(visited, false);
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}

	public static void dfs(int idx) {
		if(visited[idx]) return;
		System.out.print(vertices[idx].index + " ");
		visited[idx] = true;

		for(int i = 0; i < vertices[idx].links.size(); i ++) {
			int newIdx = vertices[idx].links.get(i);


			dfs(newIdx);

		}
	}

	public static void bfs(int idx) {
		queue.add(idx);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(visited[curr]) continue;
			visited[curr] = true;
			System.out.print(vertices[curr].index + " ");
			for(int i = 0; i < vertices[curr].links.size(); i ++) {
				queue.offer(vertices[curr].links.get(i));
			}
		}
	}


	public static class Node {
		int index;
		ArrayList<Integer> links;

		public Node(int index) {
			this.index = index;
			links = new ArrayList<Integer>();
		}
	}

}
