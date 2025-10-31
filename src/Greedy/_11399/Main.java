package Greedy._11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		int[] arr = new int[N];
		arr[0] = list.get(0);
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + list.get(i);
		}

		System.out.println(Arrays.stream(arr).sum());
	}
}
