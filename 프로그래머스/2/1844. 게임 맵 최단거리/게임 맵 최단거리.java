import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
            int answer = 0;
            int[][] distance = new int[maps.length][maps[0].length];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0,0));
            distance[0][0] = 1;
            int[] dh = {0,1,-1,0};
            int[] dw = {-1,0,0,1};
            while(!queue.isEmpty()){
                Point point = queue.poll();
                for(int i=0; i<4; i++){
                    int nextH = point.x + dh[i];
                    int nextW = point.y + dw[i];
                    if(nextH >= 0 && nextW >= 0 && nextH < maps.length && nextW < maps[0].length && maps[nextH][nextW] == 1 && distance[nextH][nextW] == 0){
                        queue.offer(new Point(nextH,nextW));
                        distance[nextH][nextW] = distance[point.x][point.y] + 1;
                        if(nextH == maps.length-1 && nextW == maps[0].length-1) return distance[nextH][nextW];
                    }
                }
            }
            return answer -1;
}
}