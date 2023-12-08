    

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(A);
        int length = sb.length()-1;
        
        for(int i=0; i < sb.length(); i++, length--){
            if(sb.toString().equals(B)) break;
            
            char ch = sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0, ch);
            answer++;
            
            if(answer == sb.length()){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}