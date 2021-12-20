package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_Contact_1238 {

	static int L, start, max, count;
	//	static int[][] contacts;
	static ArrayList<ArrayList<Integer>> people;
	static boolean[] called;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		queue = new LinkedList<Integer>();
		for(int t = 1; t <= 10; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			//			contacts = new int[100];
			people = new ArrayList<ArrayList<Integer>>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < L/2; i ++) {
				int caller = Integer.parseInt(st.nextToken());
				int receiver = Integer.parseInt(st.nextToken());

				int idxC = exists(caller);
				int idxR = exists(receiver);
				if(idxR == -1) {
					people.add(new ArrayList<Integer>());
					people.get(people.size()-1).add(receiver);
				}
				if(idxC != -1) people.get(idxC).add(receiver);


				else {
					people.add(new ArrayList<Integer>());
					people.get(people.size()-1).add(caller);
					people.get(people.size()-1).add(receiver);
				}

			}

			Collections.sort(people, (a1, a2) -> a1.get(0) - a2.get(0));


			// now found starting point
			max = Integer.MIN_VALUE;
			called = new boolean[people.size()];
			//			int startIdx = exists(start);

			queue.clear();


			bfs(start);



			System.out.println("#" + t + " " + max);

		}
	}

	static void bfs(int idx) {
		queue.offer(idx);
		count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int j = 0; j < size; j ++) {
				int t = queue.poll();
				int nT = exists(t);
				if(called[nT]) continue;
				called[nT] = true;
				for(int i = 1; i < people.get(nT).size(); i ++) {

					int next = people.get(nT).get(i);
					queue.offer(next);
				}
			}
			
			call(count + 1);

//			for(int i = count; i > 0; i --) {
//				int next = temp.poll();
//				int nN = exists(next);
//				if(called[nN]) continue;
//
//				if(people.get(nN).size() == 1) {
//					if(count < currCount) {
//						count = currCount;
//						max = next; continue;
//					}
//					if(count == currCount && max < next) {
//						max = next; continue;
//					}
//					continue;
//
//				}
//
//			}
//			currCount ++;

			//			for(int i = 1; i < people.get(nT).size(); i ++) {
			//
			//				int next = people.get(nT).get(i);
			//				queue.offer(next);
			//			}



		}

	}

	static void call(int step) {
		int size = queue.size();
		for(int i = 0; i < size; i ++) {
			int next = queue.poll();
			int nN = exists(next);
			if(called[nN]) continue;

			if(people.get(nN).size() == 1) {
				if(i == 0) {
					count = step;
					max = next; continue;
				}
				if(count == step && max < next) {
					max = next; continue;
				}
				continue;

			}
			queue.offer(next);
		}
	}


	static class Node {
		int index;
		int visited;
		ArrayList<Node> contacts;

		public Node(int index) {
			this.index = index;
			contacts = new ArrayList<Node>();
		}

		public void addContact(Node n) {
			contacts.add(n);
		}
	}



	static int exists( int index) {
		for(int i = 0; i < people.size(); i ++)
		{			
			if(people.get(i).get(0) == index) {
				return i;
			}
		}
		return -1;
	}

}
