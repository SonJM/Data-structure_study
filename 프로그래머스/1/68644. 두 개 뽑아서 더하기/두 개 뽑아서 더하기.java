import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> intList = new ArrayList<>(((numbers.length)*(numbers.length-1))/2);

        for(int i=0; i<numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i]+numbers[j];
                if(!intList.contains(sum))
                    intList.add(sum);
            }
        }
        Collections.sort(intList);
        int[] answer = new int[intList.size()];
        
        for(int i=0; i<intList.size(); i++){
            answer[i] = intList.get(i);
        }
        return answer;
    }
}