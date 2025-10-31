import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<Integer, String> ItoSMap = new HashMap<>();
		Map<String, Integer> StoIMap = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			ItoSMap.put(i, input);
			StoIMap.put(input, i);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String input = br.readLine();

			if(isInteger(input)) {
				int idx = Integer.parseInt(input);
				sb.append(ItoSMap.get(idx)).append("\n");
			} else {
				sb.append(StoIMap.get(input)).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
