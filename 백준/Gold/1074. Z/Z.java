import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		find(size, r, c);
		System.out.println(count);
	}
	private static void find(int size, int r, int c) {
		if(size == 1) {
			return;
		}

		int half = size / 2;

		if (r < half && c < half) {
			find(half, r, c);
		} else if (r < half && c >= half) {
			count += half * half;
			find(half, r, c - half);
		} else if (r >= half && c < half) {
			count += (half * half) * 2;
			find(half, r - half, c);
		} else {
			count += (half * half) * 3;
			find(half, r - half, c - half);
		}
	}
}
