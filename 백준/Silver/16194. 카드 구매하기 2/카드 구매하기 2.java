import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = cards[0];
        for(int i=1; i<N; i++){
            dp[i] = cards[i];
            for(int j=i-1, k=0; j>=0; j--, k++){
                dp[i] = Math.min(dp[i], cards[j] + dp[k]);
            }
        }

        System.out.println(dp[N-1]);
    }
}
