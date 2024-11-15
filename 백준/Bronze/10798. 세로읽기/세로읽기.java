import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[15][15];
        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<arr[0].length; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] != Character.MIN_VALUE){
                    result.append(arr[j][i]);
                }
            }
        }
        System.out.println(result);
    }
}
