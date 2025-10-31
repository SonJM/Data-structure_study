import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());;
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for(Integer integer : sorted) {
			if(!map.containsKey(integer)) {
				map.put(integer, rank++);
			}
		}

		for(Integer integer : list) {
			sb.append(map.get(integer)).append(" ");
		}
		System.out.println(sb);
	}
}
