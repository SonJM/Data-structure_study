import java.util.*;
import java.util.List;

class Solution {
    public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> min_pq = new PriorityQueue<>();
            PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
            List<Integer> list = new LinkedList<>();

            for (String s : operations) {
                StringTokenizer st = new StringTokenizer(s);
                char operation = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (operation == 'I') {
                    min_pq.offer(num);
                    max_pq.offer(num);
                    list.add(num);
                } else {
                    if (num == 1) {
                        if(!max_pq.isEmpty()) {
                            int n = max_pq.poll();
                            min_pq.remove((Integer) n);
                        }
                    } else {
                        if(!min_pq.isEmpty()) {
                            int n = min_pq.poll();
                            max_pq.remove((Integer) n);
                        }
                    }
                }
            }
            if(!max_pq.isEmpty() && !min_pq.isEmpty()){
                answer[0] = max_pq.peek();
                answer[1] = min_pq.peek();
            }
            return answer;
    }
}