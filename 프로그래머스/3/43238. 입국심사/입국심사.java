import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
            Arrays.sort(times);

            long maxTime = (long)times[times.length-1]*n;
            long minTime = 1;

            while(minTime<=maxTime){
                long averageTime = (minTime + maxTime)/2;
                long temp = 0;

                for (int time : times) {
                    temp += averageTime / time;
                    if (temp > n) break;
                }
                if(n > temp) minTime = averageTime + 1;
                else maxTime = averageTime - 1;
            }
            return minTime;
    }
}