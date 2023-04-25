import java.util.*;

public class LeetCode02336 {

}

class SmallestInfiniteSet {

    final Set<Integer> absent = new HashSet<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        int pretender = 1;
        while(absent.contains(pretender)) {
            ++pretender;
        }
        absent.add(pretender);
        return pretender;
    }

    public void addBack(int num) {
       absent.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
