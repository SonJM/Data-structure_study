package TwoPointer._30804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Map<Integer, Integer> map = new HashMap<>();
		int start = 0, end = 0, result = 1;
		map.put(list.get(0), 1);
		while(start <= end) {
			if(map.size() <= 2) {
				end++;
				if(end >= list.size()) break;
				map.put(list.get(end), map.getOrDefault(list.get(end), 0) + 1);
				if(map.size() <= 2)
					result = Math.max(result, end-start+1);
			} else {
				map.put(list.get(start), map.get(list.get(start)) - 1);
				if(map.get(list.get(start)) == 0) map.remove(list.get(start));
				start++;
			}
		}

		System.out.println(result);
	}
}
