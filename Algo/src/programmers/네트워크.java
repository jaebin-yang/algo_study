package programmers;

class 네트워크 {
    static int answer;
    static int[][] connections;
    public int solution(int n, int[][] computers) {
    
        connections = new int[computers.length][computers[0].length];
        // bfs 형식으로 
        for(int i = 0; i < computers.length; i ++) {
            for(int j = 0; j < computers[0].length; j ++) {
                
                if(connections[i][j] == 0 && computers[i][j] == 1)
                answer ++;
                bfs(computers, i, j);
            }
        }
        return answer;
    }
    
    public void bfs(int[][] computers, int i, int j) { // 현재 좌표에서 연결되어 있는 네트워크 감지
        if(computers[i][j] == 1) { // 연결이 존재
            if(connections[i][j] == 0) {
                connections[i][j] = answer;
                connections[j][i] = answer;
                for(int k = 0; k < computers.length; k ++) {
                   
                        bfs(computers, j, k);
                 
                }
            }
        }
    }
    
    
}
