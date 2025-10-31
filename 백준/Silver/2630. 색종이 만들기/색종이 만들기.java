import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int N, whiteCount = 0, blueCount = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(new Point(0,0), N);

		System.out.println(whiteCount);
		System.out.println(blueCount);
	}

	public static void check(Point point, int size) {
		int color = map[point.y][point.x];
		boolean flag = false;

		for(int i = point.y; i < point.y + size; i++) {
			for(int j = point.x; j < point.x + size; j++) {
				if (map[i][j] != color) {
					flag = true;
					break;
				}
			}
			if(flag) break;
		}

		if(flag) {
			int newSize = size / 2;
			check(new Point(point.x, point.y), newSize);
			check(new Point(point.x + newSize, point.y), newSize);
			check(new Point(point.x, point.y + newSize), newSize);
			check(new Point(point.x + newSize, point.y + newSize), newSize);
		} else {
			if(color == 0) whiteCount++;
			else blueCount++;
		}
	}
}
