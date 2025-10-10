import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);
		int result = 0;
		int start = 0, end = trees[N-1], mid;
		while(start <= end) {
			mid = (start + end) / 2;
			long sum = check(trees, mid);
			if(sum >= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
	public static long check(int[] trees, int mid) {
		long sum = 0;
		for (int tree : trees) {
			if (tree > mid)
				sum += tree - mid;
		}
		return sum;
	}
}
