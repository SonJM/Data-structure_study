import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point{
        int h;
        int w;
        Point(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dh = {-1,0,0,1};
    private static int[] dw = {0,-1,1,0};
    private static Map<Integer, List<Point>> islandPoints = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    setIsland(new Point(i,j), count);
                    count++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=1; i<islandPoints.size(); i++){
            for(int j=i+1; j<=islandPoints.size(); j++){
                result = checkDiff(islandPoints.get(i), islandPoints.get(j), result);
            }
        }

        System.out.println(result);
    }
    private static void setIsland(Point point, int islandNum){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(point.h,point.w));
        islandPoints.computeIfAbsent(islandNum, k -> new ArrayList<>());
        islandPoints.get(islandNum).add(point);
        visited[point.h][point.w] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = p.h + dh[i];
                int nextW = p.w + dw[i];
                if(nextH < 0 || nextW < 0 || nextH >= N || nextW >= N) continue;
                if(!visited[nextH][nextW] && map[nextH][nextW] == 1){
                    Point nextPoint = new Point(nextH, nextW);
                    queue.offer(nextPoint);
                    islandPoints.get(islandNum).add(nextPoint);
                    visited[nextH][nextW] = true;
                }
            }
        }
    }

    private static int checkDiff(List<Point> a, List<Point> b, int result){
        for (Point aP : a) {
            for (Point bP : b) {
                result = Math.min(result, Math.abs(aP.h - bP.h) + Math.abs(aP.w - bP.w) - 1);
            }
        }
        return result;
    }
}