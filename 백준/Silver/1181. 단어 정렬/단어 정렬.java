import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class ArrayComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(List.copyOf(set));
        list.sort(new ArrayComparator());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
