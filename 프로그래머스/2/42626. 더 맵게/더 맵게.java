import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i : scoville)
            queue.offer(i);

        while(!queue.isEmpty()){
            int a = queue.poll();
            if(a >= K) break;
            else if(queue.isEmpty()) {
                answer = -1;
                break;
            }
            int b = queue.poll();

            answer++;
            int newK = a+(b*2);
            queue.offer(newK);
        }
        return answer;
    }
}