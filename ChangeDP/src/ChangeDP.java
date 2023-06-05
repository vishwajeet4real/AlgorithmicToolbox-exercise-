import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    public static int minCoins(int value) {
        int[] dp = new int[value + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] coins = {1, 3, 4};
        for (int i = 1; i <= value; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[value];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int minCoins = minCoins(value);
        System.out.println(minCoins);
    }
}
