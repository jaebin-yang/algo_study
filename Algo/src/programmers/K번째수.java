package programmers;

import java.util.*;
class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i ++) {
            int sIdx = commands[i][0];
            int eIdx = commands[i][1];
            int idx = commands[i][2];
            
            int[] newArray = new int[eIdx - sIdx + 1];
            int count = 0;
            for(int j = sIdx - 1; j < eIdx; j ++) {
                newArray[count] = array[j];
                count ++;
            }
            
            Arrays.sort(newArray);
            
            answer[i] = newArray[idx - 1];
        }    
    
        
        
        return answer;
    }
}
