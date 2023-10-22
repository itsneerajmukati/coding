package dp;

import java.util.Arrays;

public class Knapsack {
    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;
        System.out.println("The Maximum value of items the thief can steal is " + knapsackTabulisation(wt, val, n, W));
    }

    private static int knapsack(int[] wt, int[] val , int len, int W) {
        int dp[][] = new int[len][W+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return knapsackUtil(wt, val, len-1, W, dp);

    }

    private static int knapsackUtil(int[] wt, int[] val, int index , int W, int[][] dp) {
        if(index == 0) {
            if(wt[index] <= W) {
                return val[index];
            }else {
                return 0;
            }
        }
        if (dp[index][W] != -1) {
            return dp[index][W];
        }
        int notTaken = knapsackUtil(wt, val, index-1, W, dp);
        int taken = Integer.MIN_VALUE;
        if(wt[index] <= W) {
            taken = val[index]+ knapsackUtil(wt, val, index-1, W- wt[index], dp);
        }
        return dp[index][W] = Math.max(notTaken,taken);
    }

    private static int knapsackTabulisation(int[] wt, int[] val, int len, int W) {
        int[][] dp = new int[len][W+1];

        for(int i= wt[0]; i<=W;i++) {
            dp[0][i]=val[0];
        }
        for(int index = 1; index < len; index++) {
            for(int cap=0;cap <= W; cap++) {
                int notTaken = dp[index-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[index] <= cap) {
                    taken = val[index] + dp[index-1][cap-wt[index]];
                }
                dp[index][cap]= Math.max(notTaken, taken);
            }
        }
        return dp[len-1][W];
    }
}