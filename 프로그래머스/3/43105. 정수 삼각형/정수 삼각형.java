import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
            int answer = triangle[0][0];
            int[][] newTriangle = triangle.clone();
            newTriangle[1][0] = triangle[0][0] + triangle[1][0];
            newTriangle[1][1] = triangle[0][0] + triangle[1][1];

            for(int i=2; i<triangle.length; i++){
                for(int j=0; j<triangle[i].length; j++){
                    if(j == 0) newTriangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    else if(j == triangle[i].length-1) newTriangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    else newTriangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
            Arrays.sort(newTriangle[newTriangle.length-1]);
            answer = newTriangle[newTriangle.length-1][newTriangle[newTriangle.length-1].length-1];
            return answer;
    }
}