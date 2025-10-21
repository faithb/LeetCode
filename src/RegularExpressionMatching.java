/**
* # Intuition
* The problem requires matching a string against a pattern that includes '.' and '*'.
* The '.' matches any single character, while '*' matches zero or more of the preceding element.
* A dynamic programming approach can be used to build a solution by considering subproblems.
* # Approach
* 1. Create a 2D boolean array `dp` where `dp[i][j]` indicates if the first `i` characters of `s` match the first `j` characters of `p`.
* 2. Initialize `dp[0][0]` to true, as an empty string matches an empty pattern.
* 3. Fill the first row of the `dp` array to handle patterns that can match an empty string (like 'a*', 'a*b*', etc.).
* 4. Iterate through each character of `s` and `p`, updating the `dp` array based on the matching rules for '.' and '*'.
* 5. Return the value in `dp[m][n]`, where `m` and `n` are the lengths of `s` and `p`, respectively.
* # Complexity
* - Time Complexity: O(m * n), where m is the length of string `s` and n is the length of pattern `p`.
* - Space Complexity: O(m * n) for the `dp` array.
* */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        String s = "aab";
        String p = ".***";
        boolean result = solution.isMatch(s, p);
        System.out.println("Does the string '" + s + "' match the pattern '" + p + "'? " + result);
    }
}
