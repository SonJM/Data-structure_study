package GraphTraversal._7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = { 0, 0, -1, 1 };
	private static final int[] dy = { -1, 1, 0, 0 };
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Queue<Node> queue = new LinkedList<>();
		int count = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				int num = Integer.parseInt(st.nextToken());
				map[n][m] = num;
				if(num == 1) queue.offer(new Node(m, n));
				if(num == 0) count++;
			}
		}

		if(count == 0) {
			System.out.println(0);
			return;
		}

		int days = -1;
		while(!queue.isEmpty()) {
			days++;
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Node curNode = queue.poll();
				for(int j=0; j<4; j++) {
					int nextX = curNode.x + dx[j];
					int nextY = curNode.y + dy[j];

					if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
					if(map[nextY][nextX] == 0) {
						map[nextY][nextX] = 1;
						queue.offer(new Node(nextX, nextY));
						count--;
					}
				}
			}
		}
		if(count != 0)
			System.out.println(-1);
		else
			System.out.println(days);
	}
}
