import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int INF = 500 * 500 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = 1;
        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int result = 0;
        for(int i=1; i<=N; i++){
            boolean temp = true;
            for(int j=1; j<=N; j++){
                if(i != j && map[i][j] == INF && map[j][i] == INF){
                    temp = false;
                    break;
                }
            }
            if(temp) result++;
        }
        System.out.println(result);
    }
}
