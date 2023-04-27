import java.util.Arrays;

public class LeetCode00319 {

    public static void main(String[] args) {
        final LeetCode00319 solver = new LeetCode00319();
        final int answer = solver.bulbSwitch(3);
        Assert.check(1  == answer, "Bad answer " + answer);
    }

    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        final int[] bulbs = new int[n];
        // round 1
        Arrays.fill(bulbs, 1);
        // round 2 .. n
        for(int round = 2; round <= n; ++round) {
            toggle(bulbs, round);
        }
        return count(bulbs);
    }

    private static void toggle(int[] bulbs, int k) {
        for(int i= 0; i< bulbs.length; ++i) {
            if ((i + 1) % k == 0)  {
                bulbs[i] = 1 - bulbs[i];
            }
        }
    }

    private static int count(int[] bulbs) {
        int answer = 0;
        for(int i= 0; i< bulbs.length; ++i) {
            answer += bulbs[i];
        }
        return answer;
    }
}
