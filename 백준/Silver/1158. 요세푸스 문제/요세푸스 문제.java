import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Deque<Integer> deque = new LinkedList<>();
		List<Integer> result = new LinkedList<>();

		for(int i=1; i<=N; i++) {
			deque.addLast(i);
		}

		while(!deque.isEmpty()) {
			for(int i=1; i<=K; i++) {
				int curr = deque.pollFirst();
				if(i == K) result.add(curr);
				else deque.addLast(curr);
			}
		}

		sb.append(result.stream().map(String::valueOf).collect(Collectors.joining(", ")));
		sb.append(">");
		System.out.println(sb);
	}
}