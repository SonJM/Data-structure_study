import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
			return Math.abs(o1) - Math.abs(o2);
		});
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else sb.append(queue.poll()).append("\n");
			} else {
				queue.offer(num);
			}
		}
		System.out.println(sb);
	}
}
