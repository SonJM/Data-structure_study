import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();

		int m = s1.length();
		int n = s2.length();
		int o = s3.length();
		int[][][] map = new int[m+1][n+1][o+1];

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=o; k++) {
					char ch1 = s1.charAt(i-1);
					char ch2 = s2.charAt(j-1);
					char ch3 = s3.charAt(k-1);
					if(ch1 == ch2 && ch2 == ch3) {
						map[i][j][k] = map[i-1][j-1][k-1] + 1;
					} else {
						map[i][j][k] = Math.max(map[i-1][j][k], Math.max(map[i][j-1][k], map[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(map[m][n][o]);
	}
}
