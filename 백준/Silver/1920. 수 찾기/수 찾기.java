import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			boolean isExist = false;

			while(start <= end) {
				int mid = (start + end) / 2;

				if(arr[mid] == target) {
					isExist = true;
					break;
				}
				else if(arr[mid] < target) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}

			if(isExist) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}
