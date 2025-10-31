import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[100];
		dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 2; dp[4] = 2;
		for(int i=5; i<100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
