
public class LeetCode01372 {

    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        step(root, false, 0);
        step(root, true, 0);
        return maxLen;
    }

    private void step(TreeNode root, boolean isLeft, int steps) {
        if (root == null) {
            return;
        }
        maxLen = java.lang.Math.max(maxLen, steps);
        if (isLeft) {
            step(root.left, false, steps + 1);
            step(root.right, true, 1);
        } else {
            step(root.right, true, steps + 1);
            step(root.left, false, 1);
        }
   }
}
