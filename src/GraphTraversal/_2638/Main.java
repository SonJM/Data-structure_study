package GraphTraversal._2638;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int N, M, time = 0;
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
				if(map[i][j] == 0 && !visited[i][j]) {
					if(!checkNull()) {
						bfs(new Point(j, i));
						removeCheese();
					}
				}
			}
		}

		System.out.println(time);
	}

	private static void bfs(Point start){
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.y][start.x] = true;

		while(!queue.isEmpty()){
			Point p = queue.poll();
			for(int i=0; i<4; i++){
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];

				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				if(map[nextY][nextX] >= 1){
					map[nextY][nextX]++;
					visited[nextY][nextX] = true;
				} else if(!visited[nextY][nextX]) {
					queue.offer(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
				}
			}
		}
	}
	private static boolean checkNull() {
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] >= 1) return false;
			}
		}
		return true;
	}
	private static void removeCheese() {
		for(int i=0; i<N; i++){
			Arrays.fill(visited[i], false);
			for(int j=0; j<M; j++){
				if(map[i][j] >= 3)
					map[i][j] = 0;
				else if(map[i][j] == 2)
					map[i][j] = 1;
			}
		}
		time++;
	}
}
