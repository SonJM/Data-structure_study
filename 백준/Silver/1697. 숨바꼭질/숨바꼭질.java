import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(N >= K) {
			System.out.println(N - K);
			return;
		}

		int[] arr = new int[100001];
		Arrays.fill(arr, -1);

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		arr[N] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == K) {
				System.out.println(arr[now]);
				return;
			}

			int next1 = now - 1;
			if (next1 >= 0 && arr[next1] == -1) {
				arr[next1] = arr[now] + 1;
				queue.offer(next1);
			}

			int next2 = now + 1;
			if (next2 <= 100000 && arr[next2] == -1) {
				arr[next2] = arr[now] + 1;
				queue.offer(next2);
			}

			int next3 = now * 2;
			if (next3 <= 100000 && arr[next3] == -1) {
				arr[next3] = arr[now] + 1;
				queue.offer(next3);
			}
		}
	}
}
