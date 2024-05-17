import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());

        char[] charArray = br.readLine().toCharArray();
        int start = 0, end = N*2, count = 0;
        StringBuilder ioi = new StringBuilder("I");
        for(int i=0; i<N; i++){
            ioi.append("OI");
        }
        while(end != charArray.length){
            StringBuilder checkIOI = new StringBuilder();
            for(int i = start; i<=end; i++){
                checkIOI.append(charArray[i]);
            }
            if(checkIOI.compareTo(ioi) == 0) count++;
            start++;
            end++;
        }
        System.out.println(count);
    }
}
