package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW_하나로_1251_K {
	
	static int T, N;
	static long distanceSum;
	
    static int[] parent;
    static int[][] island;
    static long[][] edges;
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
            // 4개
            // 1 : 2 - 3 - 4
            // 2 : 1 - 3 - 4
            // 3 : 1 - 2 - 4
            // 4 : 1 - 2 - 3 => 4 * 3 / 2
            edges = new long[(N*(N-1))/2][3]; // v1, v2, 비용
            int idx = 0;
            for(int v1 = 0; v1 < N - 1; v1 ++) {
            	for(int v2 = v1 + 1; v2 < N; v2 ++) {
            		edges[idx][0] = v1;
            		edges[idx][1] = v2;
            		edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
            		idx ++;
            	}
            }
            
            
            // 쿠르스칼
            // 정렬
            Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));
            // 집합
            parent = new int[N];
            makeSet();
            
            int cnt = 0; // 선택한 edge수 
            distanceSum = 0;
            for(int i = 0; i < (N*(N-1))/2; i ++) {
            	int a = findSet((int)edges[i][0]);
            	int b = findSet((int) edges[i][1]);
            	if(a == b) continue;
            	//union
            	if(a > b) parent[b] = a;
            	else parent[a] = b;
            	
            	distanceSum += edges[i][2];
            	
            	if(++cnt == N-1) break;
            }

            System.out.println("#" + t + " " + Math.round( distanceSum * E ));
        } 
    }
     
    static long distance(int x1, int x2, int y1, int y2) {
        long d = (long)( (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) );
        return d;
    }
 
    // index 0 ~ N-1 까지
	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	// findSet() compression 을 하면  findSet 호출 빈도가 즐어든다.
	static int findSet(int x) {
		//findSet++;
		if( parent[x] == x ) return x;
		else return parent[x] = findSet(parent[x]);
		//else return findSet(parent[x]); 
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if( px > py ) parent[py] = px;
		else parent[px] = py;
	}
 
}