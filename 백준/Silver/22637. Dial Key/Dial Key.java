import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if (M == 0) {
			System.out.println("No");
			return;
		}

		int[] arr2 = new int[M];
		st = new StringTokenizer("");
		for(int i = 0; i < M; i++) {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		int d = arr2[0];
		for(int i = 1; i < arr2.length; i++) {
			d = gcd(d, arr2[i]);
		}
		
		if (gcd(d, N) == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
}