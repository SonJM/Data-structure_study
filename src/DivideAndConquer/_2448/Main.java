package DivideAndConquer._2448;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//    11111*11111
//	  1111*1*1111
//	  111*****111
//	  11*11111*11
//	  1*1*111*1*1
//    *****1*****
public class Main {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new char[N][2*N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		draw(N, 0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(new String(map[i])).append("\n");
		}
		System.out.print(sb);
	}
	private static void draw(int n, int r, int c) {
		if (n == 3) {
			map[r][c] = '*';

			map[r + 1][c - 1] = '*';
			map[r + 1][c + 1] = '*';

			map[r + 2][c - 2] = '*';
			map[r + 2][c - 1] = '*';
			map[r + 2][c] = '*';
			map[r + 2][c + 1] = '*';
			map[r + 2][c + 2] = '*';
			return;
		}
		int newSize = n/2;
		draw(newSize, r, c);
		draw(newSize, r + newSize, c - newSize);
		draw(newSize, r + newSize, c + newSize);
	}
}