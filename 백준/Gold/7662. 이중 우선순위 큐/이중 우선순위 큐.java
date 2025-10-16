import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			solve(br, sb);
		}
		System.out.println(sb);
	}
	public static void solve(BufferedReader br, StringBuilder sb) throws Exception {
		TreeMap<Integer, Integer> queue = new TreeMap<>();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if(cmd.equals("I")) {
				queue.put(num, queue.getOrDefault(num, 0) + 1);
			} else {
				if(queue.isEmpty()) continue;

				int key = (num == 1) ? queue.lastKey() : queue.firstKey();
				int count = queue.get(key);
				if(count == 1) {
					queue.remove(key);
				} else {
					queue.put(key, count - 1);
				}
			}
		}

		if(queue.isEmpty()) {
			sb.append("EMPTY").append("\n");
		} else {
			sb.append(queue.lastKey()).append(" ").append(queue.firstKey()).append("\n");
		}
	}
}
