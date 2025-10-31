import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
    
        int num = 1;
        boolean possible = true;
    
        for(int i = 0; i < n; i++) {
            int su = arr[i];
    
            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                if(stack.isEmpty() || stack.pop() != su) {
                    possible = false;
                    break;
                }
                sb.append("-\n");
            }
        }
    
        if(possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
