import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Class{
        int start;
        int end;
        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    static public class ClassComparator implements Comparator<Class> {
        @Override
        public int compare(Class o1, Class o2) {
            if(o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Class> startClassList = new ArrayList<>();
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            startClassList.add(new Class(start, end));
            if(max < end) max = end;
        }
        startClassList.sort(new ClassComparator());
        endTimeQueue.offer(startClassList.get(0).end);
        for(int i=1; i<N; i++){
            if(endTimeQueue.peek() <= startClassList.get(i).start){
                endTimeQueue.poll();
            }
            endTimeQueue.offer(startClassList.get(i).end);
        }
        System.out.println(endTimeQueue.size());
    }
}