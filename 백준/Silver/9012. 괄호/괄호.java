import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(T-- > 0) {
			String str = br.readLine();
			int balance = 0;
			int size = str.length();
			boolean isValid = true;

			for(int i=0; i<size; i++) {
				if(str.charAt(i) == '(') {
					balance++;
				} else if(str.charAt(i) == ')') {
					balance--;
				}

				if(balance < 0) {
					isValid = false;
					break;
				}
			}

			sb.append(isValid && balance == 0 ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
	}
}
