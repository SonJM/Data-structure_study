import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i) - '`';
        }

        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum += (arr[i] * (int)Math.pow(31, i));
        }
        System.out.println(sum);
    }
}
