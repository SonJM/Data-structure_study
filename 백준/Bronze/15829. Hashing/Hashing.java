import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long result = 0;
        long pow = 1;
        long mod = 1234567891;

        for(int i = 0; i < L; i++) {
            result = (result + ((str.charAt(i) - 'a' + 1) * pow)) % mod;
            pow = (pow * 31) % mod;
        }
        System.out.println(result);
    }
}
