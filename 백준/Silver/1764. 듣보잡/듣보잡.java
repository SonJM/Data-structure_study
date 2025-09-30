import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for(int i=0; i<M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 2) {
				count++;
				sb.append(entry.getKey()).append("\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
