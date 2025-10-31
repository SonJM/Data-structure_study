package GraphTraversal._1167;

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
	static List<List<Node>> list = new ArrayList<>();
	static int N, farNode, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			while(true) {
				int nxtEnd = Integer.parseInt(st.nextToken());
				if(nxtEnd == -1) break;
				int nxtCost = Integer.parseInt(st.nextToken());
				list.get(cur).add(new Node(nxtEnd, nxtCost));
			}
		}

		dfs(1, 0, new boolean[N+1]);
		dfs(farNode, 0 , new boolean[N+1]);

		System.out.println(result);
	}
	private static void dfs(int start, int sum, boolean[] visited) {
		if(sum > result) {
			farNode = start;
			result = sum;
		}

		visited[start] = true;
		for(int i=0; i<list.get(start).size(); i++) {
			Node curNode = list.get(start).get(i);
			if(!visited[curNode.end]) {
				visited[curNode.end] = true;
				dfs(curNode.end, sum + curNode.cost, visited);
			}
		}
	}
}
