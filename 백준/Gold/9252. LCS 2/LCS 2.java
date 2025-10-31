import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final StringBuilder sb = new StringBuilder();
	static int[][] map;
	static String S1, S2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S1 = br.readLine();
		S2 = br.readLine();

		int m = S1.length();
		int n = S2.length();

		map = new int[m+1][n+1];
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				char ch1 = S1.charAt(i-1);
				char ch2 = S2.charAt(j-1);
				if(ch1 == ch2) {
					map[i][j] = map[i-1][j-1] + 1;
				} else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}

		System.out.println(map[m][n]);
		lcs(m, n);
		System.out.println(sb.reverse());
	}
	public static void lcs(int i, int j) {
		if(i == 0 || j == 0) return;
		char ch1 = S1.charAt(i-1);
		char ch2 = S2.charAt(j-1);

		if(ch1 == ch2) {
			sb.append(ch1);
			lcs(i-1, j-1);
		} else {
			if(map[i-1][j] > map[i][j-1]) {
				lcs(i-1, j);
			} else {
				lcs(i, j-1);
			}
		}
	}
}
