package GraphTraversal._1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static char[][] map;
	static boolean[] visited = new boolean[26];

	static int result = 0, R, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited[map[0][0] - 'A'] = true;
		dfs(0,0, 1);
		System.out.println(result);
	}
	private static void dfs(int x, int y, int cost) {
		if(cost > result) {
			result = cost;
		}
		for(int i=0; i<4; i++) {
			int nxtX = dx[i] + x;
			int nxtY = dy[i] + y;

			if(nxtX < 0 || nxtY < 0 || nxtX >= C || nxtY >= R) continue;

			int nextAlpha = map[nxtY][nxtX] - 'A';

			if(visited[nextAlpha]) continue;

			visited[nextAlpha] = true;
			dfs(nxtX, nxtY, cost + 1);
			visited[nextAlpha] = false;
		}
	}
}
