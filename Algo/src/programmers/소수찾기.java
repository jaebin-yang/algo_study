package programmers;

import java.util.*;

class 소수찾기 {
    static int currNum;
    static boolean[] selected;
    static int[] target;
    static int[] nums;
    static int answer;
    public int solution(String numbers) {
 
        nums = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i ++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        // nums 배열 정렬
        Arrays.sort(nums);
        selected = new boolean[numbers.length()];
        currNum = 0;
        for(int i = 1; i <= nums.length; i ++) {
            target = new int[i];
            perm(0, i);
        }
        return answer;
    }
    
    public void perm(int idx, int length) {
        if(idx == length) {
            int result = 0;
            int multiply = 1;
            if(target[0] == 0) return;
            for(int i =target.length - 1; i >= 0; i --) {
                result += target[i] * multiply;
                multiply *= 10;
            }
            if(currNum >= result) return;
            currNum = result;
            if(isItPrime(result)) answer+=1;
            return;
        }
        
        for(int i = 0; i < nums.length; i ++) {
            if(selected[i]) continue;
            
            target[idx] = nums[i];
            selected[i] = true;
            perm(idx+1, length);
            selected[i] = false;
        }

    }
    
    public boolean isItPrime(int number) {
        if(number < 2) return false;
        else{
        if(number == 2) return true;
        for(int i = 2; i < number; i ++) {
            if(number % i == 0) return false;
        }
        return true;
    }
    }
}