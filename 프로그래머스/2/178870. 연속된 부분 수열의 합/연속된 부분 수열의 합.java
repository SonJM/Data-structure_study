import java.awt.Point;
import java.util.*;
import java.util.List;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<Point> list = new ArrayList<>();
        Point p = new Point(0,0);
        int sum = sequence[0];
        while (true) {
            if (sum == k) {
                list.add(new Point(p.x, p.y));
                sum -= sequence[p.x++];
            } else if (sum > k) {
                sum -= sequence[p.x++];
            } else {
                p.y++;
                if(p.y == sequence.length) break;
                sum += sequence[p.y];
            }
        }
        int min = Integer.MAX_VALUE;
        for (Point point : list) {
            int diff = point.y - point.x;
            if (min > diff) {
                answer[0] = point.x;
                answer[1] = point.y;
                min = diff;
            }
        }
        return answer;
    }
}