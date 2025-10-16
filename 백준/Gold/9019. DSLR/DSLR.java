import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {
	private static final Map<Character, Function<Integer, Integer>> cmdMap = Map.of(
			'D', num -> ( num * 2 ) % 10000,
			'S', num -> num == 0 ? 9999 : num - 1,
			'L', num -> ( num % 1000 ) * 10 + ( num / 1000 ),
			'R', num -> ( num % 10 ) * 1000 + ( num / 10 )
	);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			sb.append(bfs(start, target)).append("\n");
		}
		System.out.println(sb);
	}

	private static String bfs(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		String[] commands = new String[10000];

		queue.offer(start);
		visited[start] = true;
		commands[start] = "";

		while(!queue.isEmpty()) {
			int curNum = queue.poll();
			if(curNum == target) {
				return commands[target];
			}
			for(Map.Entry<Character, Function<Integer, Integer>> entry : cmdMap.entrySet()) {
				int nxtNum = entry.getValue().apply(curNum);

				if(!visited[nxtNum]) {
					visited[nxtNum] = true;
					commands[nxtNum] = commands[curNum] + entry.getKey();
					queue.offer(nxtNum);
				}
			}
		}
		return commands[target];
	}
}