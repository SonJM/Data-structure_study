import java.util.*;

class Solution {
    static public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        int i=0;
        for(int n : numbers){
            strArr[i++] = String.valueOf(n);
        }
        Arrays.sort(strArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        String answer = String.join("",strArr);
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}