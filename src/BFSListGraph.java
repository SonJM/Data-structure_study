import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFSListGraph {
    static int N,M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        // 1) 시작노드표현식 : (i-1)*5(열의개수) + j
        // 2) 타겟의 번호와 타겟의 유효성(2)
        // 2-1) 타겟의 번호 : j에 -1빼면 왼쪽, j에서 1 더하면 오른쪾 등
        // 2-2) 타겟의 유효성 : i와 j가 상하좌우 길이 체크

        distance = new int[N+1];
        int start = 0;
        int target = 11;
        System.out.println(bfs(start, target));
    }
    // start 위치에서 target까지 갈 때의 최단거리
    static int bfs(int start, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int next = queue.poll();
//            System.out.print(next + " ");
            for(int node : adjList.get(next)){
                if(!visited[node]){
                    queue.offer(node);
                    distance[node] = distance[next] + 1;
                    visited[node] = true;
                    if(target == node) return distance[target];
                }
            }
        }
        return -1;
    }
}
