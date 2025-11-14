package Unclassified._9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String boom = br.readLine();
		int boomLen = boom.length();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));

			if (sb.length() >= boomLen) {
				boolean match = true;
				for (int j = 0; j < boomLen; j++) {
					if (sb.charAt(sb.length()-boomLen+j) != boom.charAt(j)) {
						match = false;
						break;
					}
				}

				if (match) {
					sb.delete(sb.length()-boomLen, sb.length());
				}
			}
		}
		if(sb.toString().isEmpty()) {
			System.out.println("FRULA");
		} else System.out.println(sb);
	}
}
