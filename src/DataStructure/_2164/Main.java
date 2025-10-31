package DataStructure._2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			queue.poll();
			int card = queue.poll();
			queue.add(card);
		}

		System.out.println(queue.poll());
	}
}


/**
 * 다른 문제 풀이 방법
 * 카드 한장을 제거하고 나머지 카드를 뒤로 옮기는 과정을 반복하는 방식으로 해결
 * 자료구조 사용 대신 특정 패턴을 찾아서 해결
 * 문제의 핵심은 마지막에 남는 카드의 위치를 찾는 것
 * 이 문제는 2의 거듭제곱과 관련이 있으며, 마지막에 남는 카드는 항상 2의 거듭제곱 형태로 나타난다.
 * 예를 들어, 1, 2, 4, 8, 16, ... 등
 * 따라서, 주어진 카드의 수 N에 대해 가장 가까운 2의 거듭제곱을 찾고, 그 값을 이용하여 마지막에 남는 카드의 위치를 계산한다.
 * 계산식: 2 * (N - M) 또는 N
 * M은 N보다 작거나 같은 가장 큰 2의 거듭제곱 값
 */
//public class Main {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int M = gudup(N);
//
//		int result = 2 * (N - M);
//		if(isgudup(N)) result = N;
//		System.out.println(result);
//	}
//
//	private static int gudup(int N) {
//		int M = 1;
//		while (M <= N) {
//			M *= 2;
//		}
//		return M / 2;
//	}
//
//	private static boolean isgudup(int N) {
//		return (N & (N - 1)) == 0;
//	}
//}
