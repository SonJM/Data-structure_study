import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m=0; m<N; m++){
            for(int s=0; s<N; s++){
                for(int e=0; e<N; e++){
                    if(map[s][e] == 1 || map[s][m] == 1 && map[m][e] == 1)
                        map[s][e] = 1;
                }
            }
        }

        Arrays.stream(map).forEach(arr -> {
            Arrays.stream(arr).forEach(num -> System.out.printf("%d ", num));
            System.out.println();
        });
    }
}
