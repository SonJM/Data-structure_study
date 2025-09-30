import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();

		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();

			if(cmd.equals("all")) {
				list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
			} else if(cmd.equals("empty")) {
				list = new LinkedList<>();
			} else {
				int num = Integer.parseInt(st.nextToken());
				switch (cmd) {
					case "add":
						list.add(num);
						break;
					case "check":
					{
						if (list.contains(num)) {
							sb.append(1).append("\n");
						} else {
							sb.append(0).append("\n");
						}
						break;
					}
					case "remove":
					{
						for(int i=0; i<list.size(); i++) {
							if(list.get(i) == num) list.remove(i);
						}
						break;
					}
					case "toggle":
					{
						boolean flag = false;
						for(int i=0; i<list.size(); i++) {
							if(list.get(i) == num) {
								list.remove(i);
								flag = true;
							}
						}
						if(!flag) list.add(num);
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
