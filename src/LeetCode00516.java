public class LeetCode00516 {

    public static void main(String[] args) {
        final LeetCode00516 solver = new LeetCode00516();
        int answer = solver.longestPalindromeSubseq("bbbab");
        Assert.check(4 == answer, "Bad answer " + answer);
        answer = solver.longestPalindromeSubseq("cbbd");
        Assert.check(2 == answer, "Bad answer " + answer);
    }

    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        final int[][] memo = new int[n][n];
        return recurr(s, 0, n - 1, memo);
    }

    private static int recurr(String s, int from, int to, int[][] memo) {
          if (memo[from][to] != 0) {
              return memo[from][to];
          } else if (from > to) {
              return 0;
          } else if (from == to) {
              return 1;
          } else if (s.charAt(from) == s.charAt(to)) {
              final int result = 2 + recurr(s, from + 1, to - 1, memo);
              memo[from][to] = result;
              return result;
          } else {
              final int result = Math.max(recurr(s, from, to - 1, memo), recurr(s, from + 1, to , memo));
              memo[from][to] = result;
              return result;
          }
    }

}
