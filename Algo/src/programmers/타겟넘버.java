package programmers;

class 타겟넘버 {
    static int answer;
    public int solution(int[] numbers, int target) {
        // dfs 방식으로
        
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int idx, int sum, int target) {
        if(idx == numbers.length) {
            if(sum == target) answer ++;
            return;
        }
        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}
