package GraphTraversal._1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 알고리즘을 이용, 간선을 뒤집으면 X -> 집 으로 가는 최단거리 또한 알 수 있음을 알게된 문제
public class Main {
	static class Node {
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static int N, M, X;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노드 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		X = Integer.parseInt(st.nextToken()); // 도착 지점

		final List<List<Node>> list1 = new ArrayList<>();
		final List<List<Node>> list2 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list1.get(a - 1).add(new Node(b, c));
			list2.get(b - 1).add(new Node(a, c));
		}

		int[] arr = dijkstra(list1, X);
		int[] arr2 = dijkstra(list2, X);

		for(int i=1; i<=N; i++) {
			arr[i] += arr2[i];
		}
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 2]);
	}

	static int[] dijkstra(List<List<Node>> list, int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Node> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
		queue.offer(new Node(start, 0));
		dist[start] = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (dist[cur.end] < cur.cost)
				continue;
			for (int i = 0; i < list.get(cur.end - 1).size(); i++) {
				Node nxtNode = list.get(cur.end - 1).get(i);
				int newCost = cur.cost + nxtNode.cost;
				if (dist[nxtNode.end] > newCost) {
					dist[nxtNode.end] = newCost;
					queue.offer(new Node(nxtNode.end, newCost));
				}
			}
		}
		return dist;
	}
}
