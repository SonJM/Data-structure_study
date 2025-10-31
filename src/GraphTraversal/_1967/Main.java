package GraphTraversal._1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static List<List<Node>> list = new ArrayList<>();
	static int result = 0, farNode = 0;
	static boolean[] visited = new boolean[10001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		dfs(1, 0);
		Arrays.fill(visited, false);
		dfs(farNode, 0);
		System.out.println(result);
	}
	private static void dfs(int start, int sum) {
		if(sum > result) {
			farNode = start;
			result = sum;
		}

		visited[start] = true;
		for(int i=0; i<list.get(start).size(); i++) {
			Node curNode = list.get(start).get(i);
			if(!visited[curNode.end]) {
				visited[curNode.end] = true;
				dfs(curNode.end, sum + curNode.cost);
			}
		}
	}
}
