package programmers;

import java.util.*;
class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numbersToString = new String[numbers.length];
        for(int i = 0; i < numbers.length; i ++) {
            numbersToString[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numbersToString, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1s2 = Integer.parseInt(s1 + s2);
                int s2s1 = Integer.parseInt(s2 + s1);
                return s1s2 - s2s1;
            }
        });
        StringBuilder sb = new StringBuilder();
        boolean zeroInFront = numbersToString[numbersToString.length - 1].equals("0") ? true: false;
        for(int i = numbersToString.length - 1; i >= 0; i --) {
            if(zeroInFront && i > 0) {
                if(numbersToString[i].equals("0")) continue;
                else zeroInFront = false;
            }
            sb.append(numbersToString[i]);
        }
        answer = sb.toString();
        return answer;
    }

}