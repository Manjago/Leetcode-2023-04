import java.util.PriorityQueue;

public class LeetCode01046 {
    public int lastStoneWeight(int[] stones) {
        final int n = stones.length;

        if (n == 1) {
            return stones[0];
        } else if (n == 2) {
            return Math.abs(stones[0] - stones[1]);
        }


        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            queue.add(-stones[i]);
        }

        while(queue.size() >= 2) {
            final int a = queue.poll();
            final int b = queue.poll();
            final int newStone = -Math.abs(a - b);
            if (newStone != 0) {
                queue.add(-Math.abs(a - b));
            }
        }

        return queue.isEmpty() ? 0 : -queue.poll();
    }
}
