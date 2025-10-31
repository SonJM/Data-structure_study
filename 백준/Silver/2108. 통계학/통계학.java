import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(avg(arr));
        System.out.println(mid(arr));
        System.out.println(frequency(arr));
        System.out.println(range(arr));

    }
    public static int avg(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return Math.round((float) sum / arr.length);
    }
    public static int mid(int[] arr){
        return arr[arr.length / 2];
    }
    public static int frequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxFreq = Collections.max(map.values());
        List<Integer> maxFreqNums = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxFreqNums.add(entry.getKey());
            }
        }
        Collections.sort(maxFreqNums);
        return maxFreqNums.size() > 1 ? maxFreqNums.get(1) : maxFreqNums.get(0);
    }
    public static int range(int[] arr){
        return arr[arr.length-1] - arr[0];
    }
}
