package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_맥주마시면서걸어가기_9205 {

static int T, N, V;
static int BIG = 101*23767*2;
static int[][] input;
static int[][] matrix;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
        N = Integer.parseInt(br.readLine());
        V = N + 2;
        
        input = new int[V][2];
        matrix = new int[V][V];
        
        // 입력 처리
        for (int i = 0; i < V; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 입력으로부터 인접행렬을 만든다.
        for (int i = 0; i < V; i++) {
            int vy = input[i][0];
            int vx = input[i][1];
            
            for (int j = 0; j < V; j++) {
                if( i == j ) continue;
                int ty = input[j][0];
                int tx = input[j][1];
                int dis = Math.abs(ty-vy) + Math.abs(tx-vx); // 두 정점 사이의 거리
                
                // 맥주를 마시면서 갈 수 있는 거리  20x50
                if( dis <= 1000 ) { // happy 혹은 연결되어 있다.
                    matrix[i][j] = dis;
                }else {
                    matrix[i][j] = BIG; // sad 혹은 연결되어 있지 않다.
                }
            }
        }
        
        // 플로이드 워셜 알고리즘 적용 
        for (int k = 0; k < V; k++) { // 경유 정점
            
            for (int i = 0; i < V; i++) { // 출발 정점
                if( k == i ) continue;
                for (int j = 0; j < V; j++) { // 도착 정점
                    if( i == j || k == j ) continue;
                    
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        System.out.println( matrix[0][V-1] !=0 && matrix[0][V-1] < BIG ? "happy" : "sad");
    }

}
}