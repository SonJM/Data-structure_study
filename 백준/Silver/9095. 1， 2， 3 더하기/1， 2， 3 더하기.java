import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];

		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i=3; i<11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n-1]).append("\n");
		}

		System.out.println(sb);
	}
}