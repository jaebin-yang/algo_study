
package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷을입은애가젤다지_4485_다익스트라 {

static int N;
static int[][] map;
static boolean[][] visit;

static int[] dy = { -1, 1, 0, 0 };
static int[] dx = {  0, 0,-1, 1 };

//static int callCnt; // debug 코드

static int[][] cost;
static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1, e2) -> e1.c - e2.c );

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int t = 1;
    while(true) {
        //callCnt = 0;
        N = Integer.parseInt(br.readLine());
        if( N == 0 ) break;
        
        map = new int[N][N];
        visit = new boolean[N][N];
        cost = new int[N][N]; // Integer.MAX_VALUE

        // map 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dijkstra();
        
        System.out.println("Problem " + t + ": " + cost[N-1][N-1]);
        //System.out.println("callCnt " + t + ": " + callCnt);
        t++;
    }

}

static void dijkstra() {
    visit[0][0] = true;
    cost[0][0] = map[0][0];
    pqueue.offer(new Edge(0, 0, map[0][0]));
    
    while( !pqueue.isEmpty() ) {
        //callCnt++;
        Edge e = pqueue.poll();
        
        // 탐색
        for (int i = 0; i < 4; i++) {
            int ny = e.y + dy[i];
            int nx = e.x + dx[i];
            if( ny<0 || nx<0 || ny>=N || nx>=N || visit[ny][nx] ) continue;
            
            // ny, nx 새로운 좌표의 기존 비용 cost[ny][nx] 의 비교대상은 e.c + map[ny][nx]
            if( e.c + map[ny][nx] < cost[ny][nx] ) {
                visit[ny][nx] = true;
                cost[ny][nx] = e.c + map[ny][nx];
                pqueue.offer(new Edge(ny, nx, cost[ny][nx]));
            }

        }
    }
}
// 간선 - 정점
static class Edge{
    int y;
    int x;
    int c;
    
    public Edge(int y, int x, int c) {
        this.y = y;
        this.x = x;
        this.c = c;
    }
}
}