public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 99;
        int count = 0;
        // 최소동전의 개수 산출
        for(int i=coins.length-1; i>=0; i--){
            count += amount / coins[i];
            amount %= coins[i];
        }
        System.out.println(count);
    }
}
