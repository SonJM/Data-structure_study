package DataStructure._11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Question
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * <p>
 * @Input
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * <p>
 * @Output
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * <p>
 * @Example-Input
 * 5
 * 0 4
 * 1 2
 * 1 -1
 * 2 2
 * 3 3
 * @Example-Output
 * 1 -1
 * 1 2
 * 2 2
 * 3 3
 * 0 4
 */
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
