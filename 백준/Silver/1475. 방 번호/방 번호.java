import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String room = bufferedReader.readLine();
        int[] arr = new int[9];
        Arrays.fill(arr, 0);
        for(int i=0; i<room.length(); i++){
            int num = Integer.parseInt(String.valueOf(room.charAt(i)));
            if(num != 6 && num != 9) arr[num]++;
            else arr[6]++;
        }
        arr[6] = Math.round((float) arr[6] / 2);
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}
