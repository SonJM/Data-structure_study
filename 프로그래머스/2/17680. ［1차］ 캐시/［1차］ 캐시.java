import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for (String city : cities) {
            if(cache.contains(city.toLowerCase())){
                cache.remove(city.toLowerCase());
                cache.add(city.toLowerCase());
                answer++;
            } else {
                answer += 5;
                cache.add(city.toLowerCase());
            }
            if(cache.size() > cacheSize) cache.remove(0);
        }
        return answer;
    }
}