import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        br.close();
        for(int i=1; i<=10000; i++){
            int count = map.getOrDefault(i, 0);
            for(int j=0; j<count; j++) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
