import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[15][15];
        for(int i=0; i<15; i++){
            for(int j=1; j<15; j++){
                if(i == 0) arr[i][j] = j;
                else if(j == 1) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
