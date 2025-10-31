package DataStructure._1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());

			if(num == 0) {
				if(!queue.isEmpty()) sb.append(queue.poll()).append("\n");
				else sb.append(0).append("\n");
			} else {
				queue.offer(num);
			}
		}

		System.out.println(sb);
	}
}
