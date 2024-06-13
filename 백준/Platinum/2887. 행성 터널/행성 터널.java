import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Planet{
        int num;
        int x, y, z;

        public Planet(int num, int x, int y, int z){
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int[] parents;
    static List<Planet> planetList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            planetList.add(new Planet(i, X, Y, Z));
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        planetList.sort((o1, o2) -> o1.x - o2.x);
        for (int i = 1; i < N; i++) {
            int cost = Math.abs(planetList.get(i).x - planetList.get(i-1).x);
            edges.add(new Edge(planetList.get(i).num, planetList.get(i-1).num, cost));
        }

        planetList.sort((o1, o2) -> o1.y - o2.y);
        for (int i = 1; i < N; i++) {
            int cost = Math.abs(planetList.get(i).y - planetList.get(i-1).y);
            edges.add(new Edge(planetList.get(i).num, planetList.get(i-1).num, cost));
        }

        planetList.sort((o1, o2) -> o1.z - o2.z);
        for (int i = 1; i < N; i++) {
            int cost = Math.abs(planetList.get(i).z - planetList.get(i-1).z);
            edges.add(new Edge(planetList.get(i).num, planetList.get(i-1).num, cost));
        }

        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        System.out.println(kruskal(edges));
    }
    public static int kruskal(PriorityQueue<Edge> edges){
        int sum = 0;
        int count = 0;

        while (!edges.isEmpty() && count < N - 1) {
            Edge edge = edges.poll();
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                sum += edge.cost;
                count++;
            }
        }

        return sum;
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a > b){
            parents[a] = b;
        } else parents[b] = a;
    }
    public static int find(int x){
        if(parents[x] == x) return x;
        else return find(parents[x]);
    }
}
