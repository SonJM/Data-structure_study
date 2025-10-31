import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, 0);
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, i);
		}

		List<Integer> list = new ArrayList<>(map.values());
		List<Integer> result = new ArrayList<>();
		result.add(list.get(0));
		for(int i=1; i<N; i++) {
			int nxt = list.get(i);
			if(result.get(result.size()-1) < nxt) {
				result.add(nxt);
			} else {
				int left = 0;
				int right = result.size()-1;

				while(left < right) {
					int mid = (left + right) / 2;
					if(result.get(mid) < nxt) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				result.set(right, nxt);
			}

		}

		System.out.println(result.size());
	}
}
