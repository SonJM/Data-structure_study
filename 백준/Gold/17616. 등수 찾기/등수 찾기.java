import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int count = 1;
    static List<List<Integer>> forward = new ArrayList<>();
    static List<List<Integer>> backward = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, N).forEach(i -> forward.add(new ArrayList<>()));
        IntStream.rangeClosed(0, N).forEach(i -> backward.add(new ArrayList<>()));

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            forward.get(A).add(B);
            backward.get(B).add(A);
        }

        dfs(X, forward, new boolean[N+1]);
        int backCount = count;
        count = 1;
        dfs(X, backward, new boolean[N+1]);
        int frontCount = count;

        System.out.println(frontCount + " " + (N - backCount + 1));
    }

    public static void dfs(int now, List<List<Integer>> graph, boolean[] visited) {
        for(int next : graph.get(now)) {
            if(!visited[next]) {
                visited[next] = true;
                count++;
                dfs(next, graph, visited);
            }
        }
    }
}
