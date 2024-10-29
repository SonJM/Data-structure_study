import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Item{
        int w;
        int v;
        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    private static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            items[i] = new Item(time, score);
        }
        int[][] dp = new int[N + 1][K + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(items[i].w <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].w] + items[i].v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
