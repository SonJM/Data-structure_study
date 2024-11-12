import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] list = new int[A];
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<A; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
            sum += num;
            if(max < num) max = num;
        }

        long start = 1;
        long end = max;
        long result = 0;

        while(start <= end) {
            int count = 0;
            long mid = (start+end) / 2;
            for(int i: list){
                count += (int)(i / mid);
            }
            if(count >= B) {
                result = Math.max(result, mid);
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(result);
    }
}
