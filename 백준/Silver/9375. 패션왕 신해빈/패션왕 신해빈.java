import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			Map<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();

				map.put(type, map.getOrDefault(type, 0) + 1);
			}

			int sum = 1;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				int num = entry.getValue();
				sum *= (num + 1);
			}
			sum--;
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
