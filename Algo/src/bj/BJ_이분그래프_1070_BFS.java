package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_이분그래프_1070_BFS {

	static int K, V, E;
	static ArrayList<ArrayList<Integer>> vertex = new ArrayList<ArrayList<Integer>>();
	static boolean[] visit;
	static char[] group; // group[3] = 'A'
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		for(int k = 1; k <= K; k ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			visit = new boolean[V+1];
			group = new char[V+1];
			
			vertex.clear();
			
			// 인접 리스트 구성
			for(int i = 0; i <= V; i ++) {
				vertex.add(new ArrayList<Integer>());
			}
			
			for(int i = 1; i <= E; i ++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				// 양쪽 정점 모두 연결
				
				vertex.get(v1).add(v2);
				vertex.get(v2).add(v1);
			}
			
			boolean isBG = true;
			for(int i = 1; i <= V; i ++) { //  비연결그래프 고려
				if(visit[i]) continue; // 연결되었다면 방문했을 것
				if(!bfs(i)) { //bfs false를 리턴
					isBG = false;
					break;
				}
			}
			
			System.out.println(isBG ? "YES" : "NO");
		}

	}

	static boolean bfs(int v) {
		queue.clear();
		
		visit[v] = true;
		group[v] = 'A';
		
		queue.offer(v);
		while(!queue.isEmpty()) {
			// 꺼내서 연결된 정점 고려
			int cv = queue.poll();
			for(int nv : vertex.get(cv)) {
				// 만약 방문X => 다른 그룹 부여
				// 방문 O <= 그룹이 다른가 같은가 check
				
				if(visit[nv]) {
					if(group[nv] == group[cv]) return false;
				} else {
					visit[nv] = true;
					group[nv] = (group[cv] == 'A' ? 'B':'A');
					queue.offer(nv);
				}
			}
		}
		return true;
	}
}
