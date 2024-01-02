import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
            Arrays.sort(times);

            long maxTime = (long)times[times.length-1]*n;
            long minTime = 1;

            while(minTime<=maxTime){
                long avgTime = (minTime + maxTime)/2;
                long temp = 0;

                for (int time : times) {
                    temp += avgTime / time;
                    if (temp > n) break;
                }
                if(n > temp) minTime = avgTime + 1;
                else maxTime = avgTime - 1;
            }
            return minTime;
    }
}