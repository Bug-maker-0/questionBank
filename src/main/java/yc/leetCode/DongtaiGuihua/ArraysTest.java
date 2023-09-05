package yc.leetCode.DongtaiGuihua;

import java.util.Arrays;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-08-19
 */
public class ArraysTest {

    public static int countConstructWays(int[] a) {
        int aSum = 0;
        for (int num : a) {
            aSum += num;
        }
        int n = a.length;
        int[][] dp = new int[n + 1][aSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; // j为0时，只有一种方式，即所有元素都为0
            for (int j = 0; j <= aSum; j++) {
                dp[i][j] = dp[i - 1][j]; // 不使用a[i]的情况
                if (j >= a[i - 1]) {
                    for (int k = 1; k <= a[i - 1]; k++) {
                        if (j >= a[i - 1] - k) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - a[i - 1] + k]) % 1000000007;
                        }
                    }
                }
            }
        }

        return dp[n][aSum];
    }


        public static int[] constructArray(int[] a) {
            int n = a.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }

            int[] b = new int[n];
            int mod = (int) Math.pow(10, 9) + 7;

            for (int i = 0; i < n; i++) {
                b[i] = (sum - a[i] + mod) % mod;
                sum = (2 * sum - a[i] + mod) % mod;
            }

            return b;
        }

        public static void main(String[] args) {
            int[] a = {4, 3, 6, 2, 1, 5};

            int[] b = constructArray(a);
            System.out.println(Arrays.toString(b));


            int ways = countConstructWays(a);
            System.out.println(ways);


        }

}
