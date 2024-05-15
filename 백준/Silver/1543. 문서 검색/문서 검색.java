import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String temp = br.readLine();
        int count = 0;
        while(!str.isBlank()){
            if(str.startsWith(temp)) {
                str = str.substring(temp.length());
                count++;
            } else str = str.substring(1);
        }
        System.out.println(count);
    }
}
