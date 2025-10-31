import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long start = 1;
        int result = 1;
        for(int i=1; i<N; i++){
            start += 6L * (i-1);
            if(N <= start) {
                result = i;
                break;
            }
        }
        if(N == 1) System.out.println(1);
        else if(N == 2) System.out.println(2);
        else System.out.println(result);
    }
}
