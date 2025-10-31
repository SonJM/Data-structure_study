package GraphTraversal._1865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			List<List<Node>> list = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<>());
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list.get(S).add(new Node(E, time));
				list.get(E).add(new Node(S, time));
			}

			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list.get(S).add(new Node(E, time * (-1)));
			}
			if(bellmanFord(list, N)) {
				sb.append("YES\n");
			} else sb.append("NO\n");
		}
		System.out.println(sb);
	}
	private static boolean bellmanFord(List<List<Node>> list, int N) {
		int[] dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (Node node : list.get(j)) {
					int v = node.end;
					int w = node.cost;

					if (dist[v] > dist[j] + w) {
						dist[v] = dist[j] + w;

						if (i == N) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
