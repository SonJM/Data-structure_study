import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long A, long B, long C) {
        if(B == 0) return 1;
        if(B == 1) return A % C;

        long half = pow(A, B/2, C);

        if(B % 2 == 0) {
            return half * half % C;
        } else {
            return (half * half % C) * A % C;
        }
    }
}
