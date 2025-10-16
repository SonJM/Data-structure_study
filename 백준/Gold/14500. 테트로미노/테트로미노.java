import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static boolean[][] visited;
	private static int N, M, result = 0;
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				List<Integer> list = new ArrayList<>();
				list.add(map[i][j]);
				dfs(new Point(j, i), list);
				visited[i][j] = false;

				checkTShape(new Point(j, i));
			}
		}

		System.out.println(result);
	}
	public static void dfs(Point curP, List<Integer> list) {
		if(list.size() == 4) {
			result = Math.max(result, list.stream().mapToInt(m -> m).sum());
			return;
		}
		for(int i=0; i<4; i++) {
			int nextX = curP.x + dx[i];
			int nextY = curP.y + dy[i];
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX]) continue;
			visited[nextY][nextX] = true;
			list.add(map[nextY][nextX]);
			dfs(new Point(nextX, nextY), list);
			visited[nextY][nextX] = false;
			list.remove(list.size()-1);
		}
	}

	public static void checkTShape(Point point) {
		int[][] wings = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < 4; i++) {
			int sum = map[point.y][point.x];
			boolean isPossible = true;

			for (int j = 0; j < 3; j++) {
				int nx = point.x + wings[(i + j) % 4][0];
				int ny = point.y + wings[(i + j) % 4][1];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					isPossible = false;
					break;
				}
				sum += map[ny][nx];
			}
			if(isPossible) {
				result = Math.max(result, sum);
			}
		}
	}
}
