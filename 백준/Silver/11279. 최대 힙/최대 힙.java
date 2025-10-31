import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				try {
					int data = queue.poll();
					sb.append(data).append("\n");
				} catch (NullPointerException e) {
					sb.append(0).append("\n");
				}
			} else {
				queue.offer(num);
			}
		}
		System.out.println(sb);
	}
}
