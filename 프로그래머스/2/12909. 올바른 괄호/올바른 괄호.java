import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();

        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(')
            return false;
        else {
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(')
                    queue.offer(s.charAt(i));
                else {
                    if(queue.isEmpty()) return false;
                    queue.poll();
                }
                if(i == s.length()-1 && !queue.isEmpty()) return false;
            }
        }
        return true;
    }
}