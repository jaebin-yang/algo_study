package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_하나로_1251_P {
	
	static int T, N;
	static long distanceSum;
//    static int[] parent;
    static int[][] island;
//    static long[][] edges;
    static ArrayList<ArrayList<Edge>> vertex;
    static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1, e2) -> Long.compare(e1.c, e2.c));
    static boolean[] visit;
    static double E;
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
        T = Integer.parseInt(br.readLine());
        
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            island = new int[N][2];
            // x 좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }
            
            // y 좌표
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	island[i][1] = Integer.parseInt(st.nextToken());
            }
            
            E = Double.parseDouble(br.readLine());
            

            // 여기서부터 코딩
            vertex = new ArrayList<ArrayList<Edge>>();
            for (int i = 0; i < N; i++) {
            	vertex.add(new ArrayList<Edge>());
            }

            E = Double.parseDouble(br.readLine());
            
            int idx = 0;
            for(int v1 = 0; v1 < N - 1; v1 ++) {
            	for(int v2 = v1 + 1; v2 < N; v2 ++) {
            		Edge edge1 = new Edge(v2, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
            		vertex.get(v1).add(edge1);
            		Edge edge2 = new Edge(v1, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
            		vertex.get(v2).add(edge2);
            		idx ++;
            	}
            }
            
            // 초기화
            visit = new boolean[N];
            pqueue.clear();
            
            distanceSum = 0;
            int cnt = 1;
            visit[0] = true;
            pqueue.addAll(vertex.get(0));
            while(!pqueue.isEmpty()) {
            	Edge edge = pqueue.poll();
            	if(visit[edge.v]) continue;
            	visit[edge.v] = true;
            	pqueue.addAll(vertex.get(edge.v));
            	
            	distanceSum += edge.c;
            	cnt ++;
            	if(cnt == N) break;
            }
            

            System.out.println("#" + t + " " + Math.round( distanceSum * E ));
        } 
    }
     
    static long distance(int x1, int x2, int y1, int y2) {
        long d = (long)((Math.pow(x1-x2,2) + Math.pow(y1-y2,2)));
        return d;
    }
 
	static class Edge{
		int v;
		long c;
		
		public Edge(int v, long c) {
			this.v = v;
			this.c = c;
		}
	}
 
}