package 动态规划;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class 剑指Offer47_礼物的最大价值 {

    public int maxValue1(int[][] grid) {
        // 求出行列
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength + 1][colLength + 1];

        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                dp[i][j] = Math.max(dp[i -1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[rowLength][colLength];
    }

    public int maxValue(int[][] grid) {
        // 求出行列
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] dp = new int[colLength + 1];

        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                dp[j] = Math.max(dp[j], dp[j-1]) + grid[i-1][j-1];
            }
        }

        return dp[colLength];
    }

}
