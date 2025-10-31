package Unclassified._1918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String cmd = br.readLine();

		Stack<Character> stack = new Stack<>();
		for(int i=0; i<cmd.length(); i++) {
			char c = cmd.charAt(i);

			if(c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else {
				while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
	public static int getPriority(char op) {
		if (op == '*' || op == '/') {
			return 2;
		} else if (op == '+' || op == '-') {
			return 1;
		} else if (op == '(') {
			return 0;
		}
		return -1;
	}
}
