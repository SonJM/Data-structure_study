import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
        // 1,4,5 동전이 있을 때 13원이 되게 하는 최소 동전의 개수
        // 식 : f(n) = min(f(n-a) : for a in coins) + 1
        // 일반 for문 : 메모이제이션 : new int[amount];
        int[] coins = {1,4,5};
        int price = 13;
        int[] count = new int[price+1];
        count[1] = 1;
        for (int j : coins) {
            count[j] = 1;
        }
        for(int i=2; i<=price; i++){
            for (int coin : coins) {
                if(i+coin > price) continue;
                if (count[i + coin] == 0)
                    count[i + coin] = count[i] + 1;
                else count[i + coin] = Math.min(count[i] + 1, count[i + coin]);
            }
        }
        System.out.println(count[price]);

        // 최소 동전의 개수 산출(강사님 코드)
        int answer = 0;
        int[] arr = new int[price+1];
        arr[1] = 1;
        for(int i=2; i<=price; i++){
            int min = price;
            for(int c : coins){
                if(i-c < 0) continue;
                if(min > arr[i-c]){
                    min = arr[i-c];
                }
            }
            arr[i] = min+1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
