class Solution {
    public int solution(int angle) {
        int answer = 0;
        answer = angle > 90 ? 3 : 1;
        if(angle == 90) answer = 2;
        else if(angle == 180) answer = 4;
        return answer;
    }
}