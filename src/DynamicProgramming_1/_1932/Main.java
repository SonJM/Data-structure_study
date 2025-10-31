package DynamicProgramming_1._1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}

		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Math.max(arr[i][j] + arr[i+1][j], arr[i][j] + arr[i+1][j+1]);
			}
		}

		System.out.println(arr[0][0]);
	}
}
