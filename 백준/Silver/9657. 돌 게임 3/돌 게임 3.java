import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stone = Integer.parseInt(br.readLine());
        String[] game = {"CY", "SK", "CY", "SK", "SK", "SK", "SK"};
        System.out.println(game[stone % 7]);
    }
}
