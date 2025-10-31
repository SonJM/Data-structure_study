import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {-1, 1 ,0 ,0};
	private static final int[] dy = {0, 0 ,1 ,-1};
	private static int N, M, count = 0;
	private static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Point doyeon = new Point();
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char[] chars = str.toCharArray();
				map[i][j] = chars[j];
				if(chars[j] == 'I') doyeon = new Point(j, i);
			}
		}
		bfs(doyeon, new boolean[N][M]);
		if(count == 0)
			System.out.println("TT");
		else 
			System.out.println(count);
	}
	private static void bfs(Point doyeon, boolean[][] visited) {
		visited[doyeon.y][doyeon.x] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(doyeon);

		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int i=0; i<4; i++) {
				int nextY = point.y + dy[i];
				int nextX = point.x + dx[i];

				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == 'X' || visited[nextY][nextX]) continue;
				visited[nextY][nextX] = true;
				if(map[nextY][nextX] == 'P') count++;
				queue.offer(new Point(nextX, nextY));
			}
		}
	}
}
