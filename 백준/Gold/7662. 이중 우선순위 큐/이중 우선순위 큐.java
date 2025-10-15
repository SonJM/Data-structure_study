import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			TreeMap<Integer, Integer> queue = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(cmd.equals("I")) {
					queue.put(num, queue.getOrDefault(num, 0) + 1);
				} else if (cmd.equals("D")) {
					if(!queue.isEmpty()) {
						if(num == 1) {
							Map.Entry<Integer, Integer> entry = queue.pollLastEntry();
							int key = entry.getKey();
							int value = entry.getValue() - 1;
							if(value > 0) queue.put(key, value);
						} else if(num == -1) {
							Map.Entry<Integer, Integer> entry = queue.pollFirstEntry();
							int key = entry.getKey();
							int value = entry.getValue() - 1;
							if(value > 0) queue.put(key, value);
						}
					}
				}
			}
			if(queue.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else if(queue.size() == 1) {
				int num = queue.pollFirstEntry().getKey();
				sb.append(num).append(" ").append(num).append("\n");
			} else {
				sb.append(queue.pollLastEntry().getKey()).append(" ").append(queue.pollFirstEntry().getKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
