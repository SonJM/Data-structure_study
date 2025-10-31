package Math._27323;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 직사각형의 넓이 구하는 문제
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		System.out.println(a*b);
	}
}
