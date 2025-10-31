import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			int K = Integer.parseInt(br.readLine());

			if(K != 0) stack.push(K);
			else stack.pop();
		}
		System.out.println(stack.stream().mapToInt(m -> m).sum());
	}
}
