import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] suffixSum = new int[N];
        suffixSum[N-1] = arr[N-1];
        for(int i = N-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + arr[i];
        }

        long result = 0;
        for(int i=0; i<N-1; i++){
            result += (long)arr[i] * suffixSum[i+1];
        }

        System.out.println(result);
    }
}
