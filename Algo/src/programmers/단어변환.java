package programmers;

import java.util.*;
class 단어변환 {
    static Queue<Node> queue = new LinkedList<Node>(); 
    static boolean[] selected;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        queue.clear();
        selected = new boolean[words.length];
        
        // words안에 타겟이 있는지 체크
        boolean exists = false;
        for(int i = 0; i < words.length; i ++) {
            if(target.equals(words[i])) exists = true;
        }
        
        if(exists) {
        
            for(int i = 0; i < words.length; i ++) {
                if(canChange(begin, words[i])) {
                   queue.offer(new Node(i, 1));
                }
            }

            while(!queue.isEmpty()) {
                Node curr = queue.poll();
                if(target.equals(words[curr.idx])) {
                    answer = curr.step;
                    break;
                }
                selected[curr.idx] = true;
                for(int j = 0; j < words.length; j ++) {
                    if(!selected[j] && canChange(words[curr.idx], words[j])) {
                        queue.offer(new Node(j, curr.step+1));
                }
            }
                
            }
        }
        
        return answer;
    }
    
    public boolean canChange(String src, String tgt) {
        int diffCount = 0;
        for(int i = 0; i < src.length(); i ++) {
            if(src.charAt(i) != tgt.charAt(i)) diffCount ++;
            if(diffCount > 1) return false;
        }
        if(diffCount == 1) return true;
        else return false;
    }
}

class Node {
    int idx;
    int step;
    
    public Node(int idx, int step) {
        this.idx = idx;
        this.step = step;
    }
}
