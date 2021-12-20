package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소_14502_2 {

static int N, M, max;
static int[][] map, wallMap, virusMap;
static boolean[][] visit;

static int[] dy = { -1, 1, 0, 0 };
static int[] dx = { 0, 0, -1, 1 };

static Queue<Node> queue = new LinkedList<Node>();

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    wallMap = new int[N][M];
    //visit = new boolean[N][M];
    
    max = Integer.MIN_VALUE;
    
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j] = wallMap[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    // map 을 순회하면서 0 자리 (벽을 세울 수 있는 자리) 에 벽을 하나 놓고 mark wall() 호출-실행-종료 unmark
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if( map[i][j] == 0 ) {
                wallMap[i][j] = 1;
                wall( 1 );
                wallMap[i][j] = 0;
            }
        }
    }
    
    System.out.println(max);
}

static void wall(int cnt) {
    // 기저조건
    if( cnt == 3 ) {
        virus();
        return;
    }
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if( wallMap[i][j] == 0 ) {
                wallMap[i][j] = 1;
                wall( cnt + 1 );
                wallMap[i][j] = 0;
            }
        }
    }
}

static void virus() {
    visit = new boolean[N][M];
    virusMap = new int[N][M];
    
    // map 복사
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            virusMap[i][j] = wallMap[i][j]; // 벽이 세워져 있다.
        }
    }
    
    // virus queue 에 넣는다.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if(virusMap[i][j] == 2) {
                visit[i][j] = true;
                queue.offer(new Node(i, j));
            }
        }
    }
    
    // virus 확산
    while( !queue.isEmpty() ) {
        Node n = queue.poll();
        for (int i = 0; i < 4; i++) {
            int ny = n.y + dy[i];
            int nx = n.x + dx[i];
            if( ny<0 || nx<0 || ny>=N || nx >=M || visit[ny][nx])continue;
            if( virusMap[ny][nx] == 0 ) {
                virusMap[ny][nx] = 2;
                visit[ny][nx] = true;
                queue.offer(new Node( ny, nx ));
            }
        }
    }
    
    int sum = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if( virusMap[i][j] == 0 ) sum++;
        }
    }
    
    max = Math.max(max, sum);
}

static class Node{
    int y;
    int x;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
}