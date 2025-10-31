public class DFSArrayGraph {
    static int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };
    static boolean[] visited;
    public static void main(String[] args) {
        visited = new boolean[graph.length];
        dfs(0);
    }
    static void dfs(int start){
        System.out.print(start + " ");
        visited[start] = true;
        for(int i=0; i< graph[i].length; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i);
            }
        }
    }
}