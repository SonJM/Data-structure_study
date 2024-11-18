import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Point p1;
        Point p2;
        public Node(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }
        public void move(int maxW){
            p1.y++; p2.y++;
            if(p2.y > maxW) {
                p1 = new Point(p1.x+1, 0);
                p2 = new Point(p2.x+1, 8);
            }
        }
    }
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N+1][M+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        Node node = new Node(new Point(0,0), new Point(8,8));
        int result = Integer.MAX_VALUE;
        do {
            result = Math.min(result, check(node.p1, node.p2, true));
            result = Math.min(result, check(node.p1, node.p2, false));
            node.move(M);
        } while (node.p2.x != N+1);

        System.out.println(result);
    }
    public static int check(Point start, Point end, boolean flag){
        int count = 0;
        for(int i=start.x; i<end.x; i++){
            for(int j=start.y; j<end.y; j++){
                if(flag != checkColor(new Point(i, j))){
                    count++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        return count;
    }
    public static boolean checkColor(Point point){
        return map[point.x][point.y] == 'B';
    }
}

