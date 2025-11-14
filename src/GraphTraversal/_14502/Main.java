package GraphTraversal._14502;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int result = 0, N, M;
	static final Queue<Point> virusPoint = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 2) virusPoint.offer(new Point(j, i));
			}
		}

		buildWall(map, new boolean[N][M], 0);
		System.out.println(result);
	}
	private static void buildWall(int[][] map, boolean[][] visited,int cnt) {
		if(cnt == 3) {
			int[][] copyMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				copyMap[i] = Arrays.copyOf(map[i], M);
			}
			result = Math.max(result, check(copyMap));
			return;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					map[i][j] = 1;
					cnt++;
					buildWall(map, visited, cnt);
					visited[i][j] = false;
					cnt--;
					map[i][j] = 0;
				}
			}
		}
	}
	private static int check(int[][] map) {
		int[][] dist = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		Queue<Point> queue = new LinkedList<>(virusPoint);
		boolean[][] visited = new boolean[N][M];
		while(!queue.isEmpty()) {
			Point curP = queue.poll();
			for(int i=0; i<4; i++) {
				int nxtX = curP.x + dist[i][0];
				int nxtY = curP.y + dist[i][1];

				if(nxtX < 0 || nxtY < 0 || nxtX >= M || nxtY >= N || visited[nxtY][nxtX]) continue;
				visited[nxtY][nxtX] = true;
				if(map[nxtY][nxtX] == 0) {
					map[nxtY][nxtX] = 2;
					queue.offer(new Point(nxtX, nxtY));
				}
			}
		}

		return countClean(map);
	}
	private static int countClean(int[][] map) {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		return count;
	}
}
