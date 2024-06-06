import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] map;
    static int[][] cluster;
    static boolean left = false;
    static int[] dh = {0, -1, 1, 0};
    static int[] dw = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for (int i=0; i<H; i++) {
            String str = br.readLine();
            for (int j=0; j<W; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            deleteMineral(H - height, left = !left);
            setCluster();
        }

        Arrays.stream(map).forEach(System.out::println);
    }
    // 왼쪽 -> 오른쪽 번갈아 가며 입력된 값(높이)의 미네랄 제거
    public static void deleteMineral(int height, boolean direction) {
        if (direction) { // 왼쪽부터 시작
            for (int i=0; i<W; i++) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    return;
                }
            }
        } else { // 오른쪽부터 시작
            for (int i=W-1; i>=0; i--) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    return;
                }
            }
        }
    }
    // findCluster(bfs)를 이용해 모든 클러스터 탐색
    private static void setCluster() {
        //클러스터 찾기
        cluster = new int[H][W];
        int cnt = 1;

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 'x' && cluster[i][j] == 0){
                    if(findCluster(new Point(i,j) ,cnt)) return;
                }
                cnt++;
            }
        }
    }
    // bfs 를 이용한 클러스터 찾기 / 리스트를 이용해 클러스터 관리
    public static boolean findCluster(Point point, int cnt) {
        int low_height = Integer.MIN_VALUE;

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();

        queue.add(point);
        cluster[point.x][point.y] = cnt;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            low_height = Math.max(low_height, p.x);

            for(int i=0; i<4; i++){
                int nextH = p.x + dh[i];
                int nextW = p.y + dw[i];

                if(nextH<0 || nextW<0 || nextH>=H || nextW>=W) continue;

                if(cluster[nextH][nextW] == 0 && map[nextH][nextW] == 'x'){
                    cluster[nextH][nextW] = cnt;
                    queue.add(new Point(nextH, nextW));
                }
            }
            list.add(p);
        }
        if(low_height != H-1){
            dropMineral(list);
            return true;
        }
        return false;
    }
    // 클러스터인 부분 아래로 내리기
    public static void dropMineral(List<Point> list) {
        int down = 1;

        for(Point point : list) map[point.x][point.y] = '.';
        // Label(레이블) 사용
        // for 문에서 break 발생 시 label(레이블)이 지정된 부분의 반복문을 탈출한다.
        Label: while(true){
            for(Point node : list){
                if(node.x + down == H || map[node.x + down][node.y] == 'x'){
                    down--;
                    break Label;
                }
            }
            down++;
        }
        for(Point point : list){
            map[point.x + down][point.y] = 'x';
        }
    }
}
