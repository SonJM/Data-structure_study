import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Point point = new Point();
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 2) point = new Point(j, i);
			}
		}

		int[][] result = bfs(map, point, new boolean[N][M], new int[N][M]);

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(result[i][j] == 0 && map[i][j] == 1)
					result[i][j] = -1;
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	public static int[][] bfs(int[][] map, Point start, boolean[][] visited, int[][] dist) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.y][start.x] = true;

		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length || visited[nextY][nextX]) continue;
				visited[nextY][nextX] = true;
				if(map[nextY][nextX] == 1) {
					dist[nextY][nextX] = dist[point.y][point.x] + 1;
					queue.offer(new Point(nextX, nextY));
				}
			}
		}

		return dist;
	}
}
