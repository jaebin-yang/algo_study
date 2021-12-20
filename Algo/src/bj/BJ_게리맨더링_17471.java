package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_게리맨더링_17471 {

	static int N, min, size;
	static int[] population;
	static boolean[] selected;
	
	static ArrayList<ArrayList<Integer>> edges;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		edges = new ArrayList<ArrayList<Integer>>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i ++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			edges.add(new ArrayList<Integer>());
			for(int j = 0; j < n; j ++) {
				int c = Integer.parseInt(st.nextToken());
				edges.get(i).add(c-1);
			}
		}

		min = Integer.MAX_VALUE;
		selected = new boolean[N];
		for(int i = 1; i <= N / 2; i ++) {
			size = i;
			Arrays.fill(selected, false);
			if(min > 0) {
				subset(0, 0);
			}
		}

		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);

	}

	static void subset(int idx, int count) {
		if(count == size) {
			if(check()) {
				calc();
			}
			return;
		}
		if(idx >= N) return;

		selected[idx] = true;
		subset(idx+1, count + 1);

		selected[idx] = false;
		subset(idx+1, count);

	}
	
	static boolean check() {
		int one = -1;
		int other = -1;
		for(int i = 0; i < N; i ++) {
			if(selected[i] == true) one = i;
			else other = i;
			if(one > -1 && other > -1) break;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		queue.offer(one);
		queue.offer(other);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			visited[curr] = true;
			for(int i = 0; i < edges.get(curr).size(); i ++) {
				int next = edges.get(curr).get(i);
				if(!visited[next] && selected[next] == selected[curr]) queue.offer(next);
			}
		}
		
		for(int i = 0; i < N; i ++) {
			if(!visited[i]) return false;
		}
		return true;
	}

	static void calc() {
		if(min > 0) {
			// a = true, b = false
			int a = 0; int b = 0;
			for(int i = 0; i < N; i ++) {
				if(selected[i]) {
					a += population[i];
				}
				else {
					b+= population[i];
				}		
			}
			min = min > Math.abs(a-b)? Math.abs(a-b) : min;
		}
	}

}
