import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static class SortComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.y == o2.y) return o1.x - o2.x;
			return o1.y - o2.y;
		}
	}
	public static void main(String[] args) throws Exception {
		List<Node> nodes = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes.add(new Node(x, y));
		}

		nodes.sort(new SortComparator());
		nodes.forEach(node -> System.out.println(node.x + " " + node.y));
	}
}