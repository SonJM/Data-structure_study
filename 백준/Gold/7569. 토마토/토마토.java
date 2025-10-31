import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = { 0, 0, -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, 0, 0, 1, -1 };
	private static final int[] dh = { 1, -1, 0, 0, 0, 0 };

	public static class Node {
		int x;
		int y;
		int h;

		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] map = new int[H][N][M];
		Queue<Node> queue = new LinkedList<>();
		int count = 0;
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					int num = Integer.parseInt(st.nextToken());
					map[h][n][m] = num;
					if(num == 1) queue.offer(new Node(m, n, h));
					else if(num == 0) count++;
				}
			}
		}

		int days = 0;
		while(!queue.isEmpty()) {
			boolean flag = false;
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Node curNode = queue.poll();
				for(int j=0; j<6; j++) {
					int nextH = curNode.h + dh[j];
					int nextX = curNode.x + dx[j];
					int nextY = curNode.y + dy[j];

					if(nextH < 0 || nextX < 0 || nextY < 0 || nextH >= H || nextX >= M || nextY >= N) continue;
					if(map[nextH][nextY][nextX] == 0) {
						map[nextH][nextY][nextX] = 1;
						queue.offer(new Node(nextX, nextY, nextH));
						count--;
						flag = true;
					}
				}
			}
			if(flag) days++;
		}

		if(count != 0)
			System.out.println(-1);
		else
			System.out.println(days);
	}
}
