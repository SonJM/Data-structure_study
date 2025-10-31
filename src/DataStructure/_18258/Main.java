package DataStructure._18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	private static final Deque<Integer> queue = new LinkedList<>();
	private static final StringBuilder sb = new StringBuilder();
	private static final HashMap<String, Consumer<StringTokenizer>> commandMap = new HashMap<String, Consumer<StringTokenizer>>() {
		{
			put("push", st -> queue.add(Integer.parseInt(st.nextToken())));

			put("pop", st -> {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			});

			put("size", st -> sb.append(queue.size()).append("\n"));
			put("empty", st -> sb.append(queue.isEmpty() ? "1\n" : "0\n"));
			put("front", st -> {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peek()).append("\n");
				}
			});

			put("back", st -> {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peekLast()).append("\n");
				}
			});
		}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			Consumer<StringTokenizer> action = commandMap.get(command);
			action.accept(st);
		}

		System.out.println(sb);
	}
}
