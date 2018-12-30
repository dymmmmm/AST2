package AST.kit;

public class StringDistanceUtils {
	public static int editDistance(String s1, String s2) {
		if (s1 == null || s2 == null)
			return -1;
		if (s1.equals(s2)) {
			return 0;
		}
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++)
			dp[i][0] = i;
		for (int j = 1; j <= s2.length(); j++)
			dp[0][j] = j;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static int maxSubStringLength(String s1, String s2) {
		if (s1 == null || s2 == null)
			return -1;
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				dp[i][j] = 0;
			}
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

}
