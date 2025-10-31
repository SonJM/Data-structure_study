import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		int m = s1.length();
		int n = s2.length();

		int[][] map = new int[m+1][n+1];

		for(int i=0; i<=m; i++) {
			map[i][0] = i;
		}
		for(int i=0; i<=n; i++) {
			map[0][i] = i;
		}

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				char ch1 = s1.charAt(i-1);
				char ch2 = s2.charAt(j-1);
				if(ch1 == ch2) {
					map[i][j] = map[i-1][j-1];
				} else {
					map[i][j] = Math.min(map[i-1][j-1]+1, Math.min(map[i][j-1]+1, map[i-1][j]+1));
				}
			}
		}
		System.out.println(map[m][n]);
	}
}
