import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 효율적인 해결책: 비트마스킹
 * 연산	비트마스킹 연산	설명
 * add x	S |= (1 << x)	x번째 비트를 1로 만듭니다. (OR 연산)
 * remove x	S &= ~(1 << x)	x번째 비트를 0으로 만듭니다. (AND와 NOT 연산)
 * check x	(S & (1 << x)) != 0	x번째 비트가 1인지 확인합니다. (AND 연산)
 * toggle x	S ^= (1 << x)	x번째 비트를 반전시킵니다. (XOR 연산)
 * all	S = (1 << 21) - 1	1~20번째 비트를 모두 1로 만듭니다.
 * empty	S = 0	모든 비트를 0으로 만들어 비웁니다.
  */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num;

			switch (cmd) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					S |= (1 << num);
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					S &= ~(1 << num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					S ^= (1 << num);
					break;
				case "all":
					S = (1 << 21) - 1;
					break;
				case "empty":
					S = 0;
					break;
			}

		}
		System.out.println(sb);
	}
}