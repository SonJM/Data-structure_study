package GraphTraversal._1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node {
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static List<List<Node>> nodes = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for(int i=0; i<=N; i++) {
			nodes.add(new ArrayList<>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			nodes.get(start).add(new Node(end, cost));
			nodes.get(end).add(new Node(start, cost));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int[] dist1 = dijkstra(1, N);
		int[] dist2 = dijkstra(v1, N);
		int[] dist3 = dijkstra(v2, N);

		long type1 = (long) dist1[v1] + (long) dist2[v2] + (long) dist3[N];
		long type2 = (long) dist1[v2] + (long) dist3[v1] + (long) dist2[N];

		long min = Math.min(type1, type2);
		System.out.println(min >= Integer.MAX_VALUE ? -1 : min);
	}
	private static int[] dijkstra(int start, int end) {
		int[] dist = new int[nodes.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		queue.offer(new Node(start, 0));
		dist[start] = 0;

		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(dist[curr.end] < curr.cost) {
				continue;
			}

			for(Node node : nodes.get(curr.end)) {
				if(dist[node.end] > curr.cost + node.cost) {
					dist[node.end] = curr.cost + node.cost;
					queue.offer(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist;
	}
}
