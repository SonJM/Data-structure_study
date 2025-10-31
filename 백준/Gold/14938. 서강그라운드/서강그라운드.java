import javax.swing.plaf.synth.Region;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int INF = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[] items = new int[N+1];
        Arrays.stream(map).forEach(row -> Arrays.fill(row, INF));
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = distance;
        }

        for(int m=1; m<=N; m++){
            for(int s=1; s<=N; s++){
                if(m == s) continue;
                for(int e=1; e<=N; e++){
                    if(s == e) continue;
                    if(map[s][m] != INF && map[m][e] != INF && map[s][e] > map[s][m] + map[m][e]){
                        map[s][e] = map[s][m] + map[m][e];
                    }
                }
            }
        }
        int result = 0;
        for(int i=1; i<=N; i++){
            int sum = items[i];
            for(int j=1; j<=N; j++){
                if(map[i][j] <= M) sum += items[j];
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
