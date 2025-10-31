import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S1 = br.readLine();
		String S2 = br.readLine();

		System.out.println(lcs(S1, S2));
	}
	public static int lcs(String S1, String S2) {
		int M = S1.length();
		int N = S2.length();
		int[][] map = new int[M + 1][N + 1];
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				char ch1 = S1.charAt(i-1);
				char ch2 = S2.charAt(j-1);

				if(ch1 == ch2) {
					map[i][j] = map[i-1][j-1] + 1;
				} else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		return map[M][N];
	}
}
