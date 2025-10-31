package DataStructure._10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	private static final Deque<Integer> deque = new LinkedList<>();
	private static final StringBuilder sb = new StringBuilder();
	private static Map<String, Consumer<StringTokenizer>> commandMap = new HashMap<String, Consumer<StringTokenizer>>() {{
		put("push_front", st -> {
			int value = Integer.parseInt(st.nextToken());
			deque.addFirst(value);
		});
		put("push_back", st -> {
			int value = Integer.parseInt(st.nextToken());
			deque.addLast(value);
		});
		put("pop_front", st -> {
			if (deque.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(deque.pollFirst()).append("\n");
			}
		});
		put("pop_back", st -> {
			if (deque.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(deque.pollLast()).append("\n");
			}
		});
		put("size", st -> sb.append(deque.size()).append("\n"));
		put("empty", st -> sb.append(deque.isEmpty() ? 1 : 0).append("\n"));
		put("front", st -> {
			if (deque.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(deque.peekFirst()).append("\n");
			}
		});
		put("back", st -> {
			if (deque.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(deque.peekLast()).append("\n");
			}
		});
	}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			Consumer<StringTokenizer> action = commandMap.get(command);
			if (action != null) {
				action.accept(st);
			}
		}

		System.out.println(sb);
	}
}
