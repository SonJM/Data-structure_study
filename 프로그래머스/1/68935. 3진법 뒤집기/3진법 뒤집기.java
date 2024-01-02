import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            while(n > 0){
                queue.offer(n%3);
                n/=3;
            }
            Queue<Integer> queue1 = new LinkedList<>();
            while(!queue.isEmpty()) queue1.offer(queue.poll());

            int size = queue1.size()-1;
            while(!queue1.isEmpty()){
                int num = queue1.poll();
                answer += num * (int)Math.pow(3,size);
                size--;
            }
            return answer;
    }
}