import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final Map<Character, Character> pairMap = Map.ofEntries(
			Map.entry('(', ')'),
			Map.entry('[',']')
	);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			boolean flag = true;
			String str = br.readLine();
			if(Objects.equals(str, ".")) break;

			Stack<Character> queue = new Stack<>();
			for(char ch : str.toCharArray()) {
				if(ch == '[' || ch == '(') queue.push(ch);
				if(ch == ']' || ch == ')') {
					if(queue.isEmpty()) {
						sb.append("no\n");
						flag = false;
						break;
					}
					char ch2 = queue.pop();
					if(pairMap.get(ch2) != ch) {
						sb.append("no\n");
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				if(!queue.isEmpty()) sb.append("no\n");
				else sb.append("yes\n");
			}
		}
		System.out.println(sb);
	}
}
