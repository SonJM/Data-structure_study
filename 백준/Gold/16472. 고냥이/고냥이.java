import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();

        int start = 0, end = 0, result = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(array[0], 1);
        while (end != array.length - 1) {
            if (map.size() <= N) {
                end++;
                map.put(array[end], map.getOrDefault(array[end], 0) + 1);
            } else {
                map.put(array[start], map.get(array[start]) - 1);
                if (map.get(array[start]) == 0) map.remove(array[start]);
                start++;
            }
            if(map.size() <= N){
                result = check(map, result);
            }
        }
        System.out.println(result);
    }
    public static int check(Map<Character, Integer> map,  int result){
        int sum = 0;
        for(Character key: map.keySet()){
            sum += map.get(key);
        }
        return Math.max(result, sum);
    }
}
