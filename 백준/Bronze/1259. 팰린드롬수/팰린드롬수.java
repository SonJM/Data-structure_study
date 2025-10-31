import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while(true){
            String input = bufferedReader.readLine();
            if(Objects.equals(input, "0")) break;
            list.add(input);
        }
        for(String str : list){
            if(Palindrome(str)) System.out.println("yes");
            else System.out.println("no");
        }
    }
    private static boolean Palindrome(String str) {
        Deque<Character> deque = str.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while(!deque.isEmpty()){
            if(deque.size() == 1) return true;
            char ch1 = deque.pollFirst();
            char ch2 = deque.pollLast();
            if(ch1 != ch2) return false;
        }
        return true;
    }
}
