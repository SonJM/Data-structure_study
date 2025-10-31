import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cmd = br.readLine();

		List<Integer> list = new ArrayList<>();
		String[] split1 = cmd.split("-");
		for(String str : split1) {
			String[] split2 = str.split("\\+");
			list.add(Arrays.stream(split2).sequential().mapToInt(Integer::parseInt).sum());
		}

		int result = list.get(0);
		for(int i=1; i<list.size(); i++) {
			result -= list.get(i);
		}

		System.out.println(result);
	}
}
