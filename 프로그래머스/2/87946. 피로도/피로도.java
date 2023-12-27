class Solution {
    static int answer = -1;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dungeon(k, dungeons, 0);
        return answer;
    }
    static public void dungeon(int k, int[][] dungeons, int count){
        if(check()){
            answer = Math.max(answer, count);
            return;
        }
        for(int i=0; i<dungeons.length; i++){
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                dungeon(k-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
            else if(k<dungeons[i][0] && !visited[i]) answer = Math.max(answer, count);
        }
    }
    static public boolean check(){
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}