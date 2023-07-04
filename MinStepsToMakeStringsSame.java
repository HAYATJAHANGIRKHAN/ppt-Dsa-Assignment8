//Given two strings word1 and word2, return *the minimum number of **steps** required to make* word1 *and* word2 *the same*.
//
//        In one **step**, you can delete exactly one character in either string.
//
//        **Example 1:**
//
//        **Input:** word1 = "sea", word2 = "eat"
//
//        **Output:** 2
//
//        **Explanation:** You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

package ppt_assignment8;

public class MinStepsToMakeStringsSame {

    public static int minSteps(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store the length of the LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of LCS is dp[m][n]
        // The minimum number of steps is (m - LCS) + (n - LCS)
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int steps = minSteps(word1, word2);
        System.out.println("Minimum steps required: " + steps);
    }
}

