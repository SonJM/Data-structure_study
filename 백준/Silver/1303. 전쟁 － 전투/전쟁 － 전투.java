import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int W, H;
    static char[][] map;
    static boolean[][] visited;
    static int[] dh = {-1, 0, 0, 1};
    static int[] dw = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W];
        for(int i=0; i<H; i++){
            map[i] = br.readLine().toCharArray();
        }

        Map<Character, Integer> result = new HashMap<>();
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    int count = bfs(new Point(i, j), map[i][j]);
                    result.put(map[i][j], (int) (result.getOrDefault(map[i][j], 0) + Math.pow(count, 2)));
                }
            }
        }
        System.out.println(result.get('W') + " " + result.get('B'));
    }
    public static int bfs(Point point, char team){
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = p.x + dh[i];
                int nextW = p.y + dw[i];
                if(nextH < 0 || nextW < 0 || nextH >= H || nextW >= W) continue;
                if(!visited[nextH][nextW] && map[nextH][nextW] == team) {
                    visited[nextH][nextW] = true;
                    count++;
                    queue.add(new Point(nextH, nextW));
                }
            }
        }
        return count;
    }
}
