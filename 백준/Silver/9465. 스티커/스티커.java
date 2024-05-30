import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[2][N];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 0: 위쪽 뽑았을 때, 1: 아래쪽 뽑았을 때, 2: 아예 안뽑았을 때
            sb.append(sticker(N, map, new int[3][N])).append("\n");
        }
        System.out.println(sb);
    }
    public static int sticker(int N, int[][] map, int[][] temp){
        temp[0][0] = map[0][0];
        temp[1][0] = map[1][0];

        for(int i=1; i<N; i++){
            temp[0][i] = Math.max(temp[2][i-1], temp[1][i-1]) + map[0][i];
            temp[1][i] = Math.max(temp[2][i-1], temp[0][i-1]) + map[1][i];
            temp[2][i] = Math.max(temp[0][i-1], temp[1][i-1]);
        }
        return Math.max(temp[2][N-1], Math.max(temp[0][N-1], temp[1][N-1]));
    }
}
