import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}

		int result = 0;
		int[][] map2 = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i-1][j-1] == 1) {
					map2[i][j] = Math.min(map2[i-1][j-1]+1, Math.min(map2[i-1][j]+1, map2[i][j-1]+1));
					result = Math.max(result, map2[i][j]);
				} else {
					map2[i][j] = 0;
				}
			}
		}
		System.out.println((int) Math.pow(result, 2));
	}
}
