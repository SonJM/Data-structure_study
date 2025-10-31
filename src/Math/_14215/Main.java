package Math._14215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		for(int i=0; i<3; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		int A = queue.poll();
		int B = queue.poll();
		int C = queue.poll();

		if(A < B + C) {
			System.out.println(A + B + C);
		} else {
			System.out.println((B + C) * 2 - 1);
		}
	}
}
