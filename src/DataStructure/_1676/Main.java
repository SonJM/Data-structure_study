package DataStructure._1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 문제를 잘 해석해보면 뒤에서부터 0이 존재한다는 것은 '10'을 곱했다는 것이다.
 소인수 분해에서 2 x 5의 개수를 세면 되는데 2의 개수가 항상 5보다 많기 떄문에
 5의 개수만 체크해도 답을 쉽게 얻을 수 있다
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		while (N >= 5) {
			count += N / 5;
			N /= 5;
		}
		System.out.println(count);
	}
}
