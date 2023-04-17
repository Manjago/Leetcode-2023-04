import java.util.ArrayList;
import java.util.List;

public class LeetCode01431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = -1;
        for(int i = 0; i < candies.length; ++i) {
            final int value = candies[i];
            if (value > maxValue) {
                maxValue = value;
            }
        }

        final List<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < candies.length; ++i) {
            final int value = candies[i];
            answer.add((value + extraCandies) >= maxValue);
        }

        return answer;
    }
}
