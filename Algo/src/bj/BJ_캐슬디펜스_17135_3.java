package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 궁사의 위치를 조합으로 바꿔가면서 시뮬레이션을 해야 하는데, 매번 map 의 적 위치를 움직이면서 하게 되면 다시 map을 초기화 해야 함. 
// 따로 적의 위치 및 거리 정보를 자료구조에 관리한다.
// while 문 안에서 한 번씩 궁사가 쏘고 남은 적은 한칸 아래로 내려오도록 구성
// 궁사가 쏘는 단계에서 대상이 되는 적을 매번 구성 후, 우선 순위에 의해 적을 꺼내서 공격  - PriorityQueue 활용

// enemy, pqueue 재사용
// lambda
// e
public class BJ_캐슬디펜스_17135_3 {

	static int N, M, D, max;
    static int[][] map;
    static int[] archer = new int[3];	// 궁수 3자리 (x 좌표)
    static List<Enemy> enemy = new ArrayList<>();
    static PriorityQueue<Enemy> pqueue = new PriorityQueue<>((e1, e2)->{
    	return e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d;
    });
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 행 - N
        N = Integer.parseInt(st.nextToken());
        // 열 - M
        M = Integer.parseInt(st.nextToken());
        // 사정거리 - 공격 거리제한
        D = Integer.parseInt(st.nextToken());
        
        // 적군 정보
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 만약 모든 enemy의 y가  Y가 된다면 방어 실패
        // 0 <= x && x < C인  x에서 3개를 고르는 조합
        // 조합이 완성되면 check() 로 확인
        comb(0, 0);
        System.out.println(max);
    }

    private static void check() {
    	
        // 각각의 상황에 맞춰 적군을 복사해서 써야한다.
        enemy.clear();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) {
                    enemy.add(new Enemy(y, x));
                }
            }
        }

        // 시뮬레이션 시작
        // 반복문 한번 수행이 한 턴
        // 적군의 r이 R이 되면 종료하고 카운트
        int dead = 0;
        while (true) {
        	
            // 궁수가 한 명씩 발사
            for (int i = 0; i < archer.length; i++) {
            	
                // pq에는 각 궁수가 쏠 수 있는 적이 등록됨
            	// 이중 적군 한명만 제거 대상
            	// 꺼낼 때 자동으로 우선순위에 의해 적이 선택됨
                pqueue.clear();
                
                int ac = archer[i];
                for (int j = 0; j < enemy.size(); j++) {
                    Enemy e = enemy.get(j);
                    // 턴 마다 새롭게 d 계산
                    e.d = Math.abs(ac - e.x) + Math.abs(N - e.y);
                    
                    // 사정거리에 있다고 다 죽는 건 아님
                    // 사정거리보다 더 가까워도 살아 남을 수 있음.
                    // 그 모든 대상을 pqueue 에 넣는다. 
                    if (e.d <= D) {
                        pqueue.offer(e);
                    }
                }
                // pq 가 비어 있지 않다면 맨 처음 녀석은 사망 표시
                if (!pqueue.isEmpty()) {
                    pqueue.poll().dead = true;
                }
            }

            // 사망자 정리 및 이동, 종료 체크        
            Iterator<Enemy> iter = enemy.iterator();
            while(iter.hasNext()) {
            	Enemy e = iter.next();
            	
            	if (e.dead) {			// 사망자 처리
            		iter.remove();
            		dead++;
            	} else if (e.y == N - 1) {	// 맨 아래 적 제외
            		iter.remove();
                } else {						// 남은 적 아래로 한 칸 이동
                    e.y++;
                }
            }
            
            // 모든 병사가 다 사라지면
            if (enemy.size() == 0) break;
        }
        
        max = Math.max(max, dead);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 3) {
            check();
            return;
        }
        if (srcIdx == M) {
            return;
        }
        
        archer[tgtIdx] = srcIdx;

        comb(srcIdx + 1, tgtIdx + 1);	// 선택(O)
        comb(srcIdx + 1, tgtIdx); 		// 선택(X)
    }

    static class Enemy {
        Integer y, x, d;	// d: 궁수와의 거리
        boolean dead;	// 사망 여부

        public Enemy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}