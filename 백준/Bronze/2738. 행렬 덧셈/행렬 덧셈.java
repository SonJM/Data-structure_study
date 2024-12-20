import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
