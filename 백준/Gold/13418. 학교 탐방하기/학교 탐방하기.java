import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 크루스 칼 알고리즘,,
public class Main {
    static int N, M;
    static int[][] graph;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[M+1][3];
        for (int i=0; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        int minValue = kruskal(false);
        int maxValue = kruskal(true);

        System.out.println(maxValue - minValue);
    }
    public static int kruskal(boolean min){
        int count = 0;
        if(min) Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        else Arrays.sort(graph, (o1, o2) -> Integer.compare(o2[2], o1[2]));

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for (int i=0; i<=M; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                if(graph[i][2] == 0) count++;
            }
        }
        return count * count;
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}
