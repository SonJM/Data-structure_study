import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int x;
		int y;

		 public Node(int x, int y) {
			 this.x = x;
			 this.y = y;
		 }
	}
	public static class CompareClass implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.x == o2.x) {
				return o1.y - o2.y;
			}
			return o1.x - o2.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] results = new Node[N];

		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Node node = new Node(x, y);
			results[N] = node;
		}
		Arrays.stream(results).sorted(new CompareClass()).forEach(r -> System.out.println(r.x + " " + r.y));
		br.close();
	}
}
