import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        Collections.sort(list);
        int start = 0, end = N-1, count = 0;
        while(start < end){
            if(list.get(start) + list.get(end) < M){
                start++;
            } else if(list.get(start) + list.get(end) == M){
                count++;
                end--;
            } else if(list.get(start) + list.get(end) > M) {
                end--;
            }
        }
        System.out.println(count);
    }
}
