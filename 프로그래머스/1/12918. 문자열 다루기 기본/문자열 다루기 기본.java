import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6) {
            answer = Pattern.matches("[0-9]+",s);   
        }
        return answer;
    }
}