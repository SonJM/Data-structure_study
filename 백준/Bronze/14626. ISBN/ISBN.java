import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		char[] arr = input.toCharArray();
		int sum = 0, lost = 0;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == '*') {
				lost = i;
				continue;
			}
			if(i % 2 == 0) {
				sum += (arr[i] - '0');
			} else {
				sum += (3 * (arr[i] - '0'));
			}
		}

		int result = lost % 2 == 0
				? 10 - (sum % 10) // 짝수 인덱스 일 때는 n 값이 그대로 들어가서 10 - (sum % 10)
				: ((10 - (sum % 10)) * 7) % 10; // 모듈러 역원
		System.out.println(result);
	}
}
