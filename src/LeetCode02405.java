import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode02405 {

    public static void main(String[] args) {
        final LeetCode02405 solver = new LeetCode02405();
        //Assert.check(4 == solver.partitionString("abacaba"), "4");
        //Assert.check(6 == solver.partitionString("ssssss"), "6");
        //Assert.check(0 == solver.partitionString(""), "0");
        //Assert.check(2 == solver.partitionString("aba"), "0");
        Assert.check(4 == solver.partitionString("hdklqkcssgxlvehva"), "4");
    }

    public int partitionString(String s) {

        final List<Set<Character>> data = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            boolean added = false;
            for (Set<Character> substring : data) {
                if (!substring.contains(c)) {
                    substring.add(c);
                    added = true;
                    break;
                }
            }
            if (!added) {
                final Set<Character> newSubstring = new HashSet<>();
                newSubstring.add(c);
                data.add(newSubstring);
            }

        }

        System.out.println(data);
        return data.size();
    }
}
