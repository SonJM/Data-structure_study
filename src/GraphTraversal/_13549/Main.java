package GraphTraversal._13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 문제이지만
// 가중치가 0과 1로 이루어져 있다면 0-1 BFS로 더 최적화된 방법으로 풀 수 있음
// 0일 땐 같은 depth이고 1일땐 다음 depth임을 의미하여 목표의 depth가 몇인지 체크하는 방식
public class Main {
	static class Node {
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static int[] dist = new int[100001];
	static boolean[] visited = new boolean[100001];
	static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(N > K) {
			System.out.println(N-K);
			return;
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		distance(N);
		System.out.println(dist[K]);
	}
	private static void distance(int start) {
		Deque<Node> deque = new ArrayDeque<>();
		deque.addFirst(new Node(start, 0));
		dist[start] = 0;
		while(!deque.isEmpty()) {
			Node curNode = deque.pollFirst();
			if(visited[curNode.end] || dist[curNode.end] < curNode.cost) continue;
			visited[curNode.end] = true;

			int nextEnd = curNode.end * 2;
			int nextCost = curNode.cost;
			if(curNode.end * 2 < 100001 && nextCost < dist[nextEnd]) {
				deque.addFirst(new Node(nextEnd, nextCost));
				dist[curNode.end*2] = curNode.cost;
			}

			nextEnd = curNode.end - 1;
			nextCost = curNode.cost + 1;
			if(nextEnd >= 0 && nextCost < dist[nextEnd]) {
				deque.addLast(new Node(nextEnd, nextCost));
				dist[curNode.end-1] = curNode.cost+1;
			}

			nextEnd = curNode.end + 1;
			nextCost = curNode.cost + 1;
			if(nextEnd < 100001 && nextCost < dist[nextEnd]) {
				deque.addLast(new Node(nextEnd, nextCost));
				dist[curNode.end+1] = curNode.cost+1;
			}
		}
	}
}
