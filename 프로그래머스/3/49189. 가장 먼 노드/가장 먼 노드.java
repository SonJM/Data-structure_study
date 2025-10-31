import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
        public int solution(int n, int[][] edge) {
            List<List<Integer>> list = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            int[] depth = new int[n+1];
            int answer = 0;
            for(int i=0; i<n+1; i++){
                list.add(new ArrayList<>());
            }
            for (int[] ints : edge) {
                list.get(ints[0]).add(ints[1]);
                list.get(ints[1]).add(ints[0]);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visited[1] = true;
            int temp = 0;
            while(!queue.isEmpty()){
                int num = queue.poll();
                for(int i : list.get(num)){
                    if(!visited[i]){
                        queue.offer(i);
                        depth[i] = depth[num] + 1;
                        if(temp < depth[i]) temp = depth[i];
                        visited[i] = true;
                    }
                }
            }
            for (int j : depth) {
                if (j == temp) answer++;
            }
            return answer;
        }
}