import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = {};
        temp = s.split(" ");
        
        int[] nums = new int[temp.length];
        for(int i=0; i<temp.length; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(nums);
        answer = nums[0] + " " + nums[nums.length-1];
        
        return answer;
    }
}