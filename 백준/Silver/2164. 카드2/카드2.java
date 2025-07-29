import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = gudup(N);

		int result = 2 * (N - M);
		if(isgudup(N)) result = N;
		System.out.println(result);
	}

	private static int gudup(int N) {
		int M = 1;
		while (M <= N) {
			M *= 2;
		}
		return M / 2;
	}

	private static boolean isgudup(int N) {
		return (N & (N - 1)) == 0;
	}
}
