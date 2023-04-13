public class LeetCode00946 {

    public static void main(String[] args) {
        final LeetCode00946 solution = new LeetCode00946();
        Assert.check(solution.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}), "Bad 1");
        Assert.check(!solution.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}), "Bad 2");
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final int n = popped.length;
        final SimpleStack stack = new SimpleStack(n);
        int pushedIndex = 0;
        int poppedIndex = 0;
        while(poppedIndex < n && pushedIndex < n) {
            final int currentPopped = popped[poppedIndex++];
            while(!stack.tryPop(currentPopped) && (pushedIndex < n)) {
                stack.push(pushed[pushedIndex++]);
            }
        }
        while(poppedIndex < n) {
            final int currentPopped = popped[poppedIndex++];
            if (!stack.tryPop(currentPopped)) {
                break;
            }
        }
        return poppedIndex == n && pushedIndex == n && stack.empty();
    }

    private static class SimpleStack {
        private final int[] data;
        private int index = 0;
        public SimpleStack(int maxSize) {
            data = new int[maxSize];
        }
        public boolean tryPop(int value) {
            if (index == 0) {
                return false;
            } else if (data[index - 1] == value) {
                --index;
                return true;
            } else {
                return false;
            }
        }
        public void push(int value) {
            data[index++] = value;
        }
        public boolean empty() {
            return index == 0;
        }
    }

}
