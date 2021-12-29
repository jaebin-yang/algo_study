package programmers;

class  모의고사 {
    public int[] solution(int[] answers) {
       
       // return answer;
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        // 정답을 몇개 맞추었는지
        int[] answerCount = new int[3];
        
        for(int i = 0; i < answers.length; i ++) {
            if(one[i % one.length] == answers[i]) answerCount[0]++;
            if(two[i % two.length] == answers[i]) answerCount[1]++;
            if(three[i % three.length] == answers[i]) answerCount[2]++;
        }
        
        // 가장 높은 점수 구하기
        int max = 0;
        for(int i = 0; i < answerCount.length; i ++) {
            max = max < answerCount[i] ? answerCount[i] : max;
        }
        
        // 가장 높은 점수 받은 사람 수
        int count = 0;
        for(int i = 0; i < answerCount.length; i ++) {
           if(answerCount[i] == max) count++;
        }
        
        int[] answer = new int[count];
        int index = 0;
        for(int i = 0; i < answerCount.length; i ++) {
           if(answerCount[i] == max) {
               answer[index] = i + 1;
               index ++;
           }
        }
        
        return answer;
    }
}
