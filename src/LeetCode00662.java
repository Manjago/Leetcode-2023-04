import java.math.BigInteger;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
  0
  0 1
  0 1 2 3
  0 1 2 3 4 5 6 7
 */

public class LeetCode00662 {

    private static final int LEN = 3000;

    private final BigInteger[] left = new BigInteger[LEN];
    private final BigInteger[] right = new BigInteger[LEN];

    public static void main(String[] args) {
        final int answer1 = new LeetCode00662().widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))
        ));
        System.out.println(answer1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        check(root, 0, BigInteger.ZERO);

        BigInteger answer = BigInteger.ZERO;
        for (int i = 0; i < LEN; ++i) {
            if (left[i] == null) {
                continue;
            }

            final BigInteger pretender = right[i].subtract(left[i]);

            if (pretender.compareTo(answer) > 0) {
                answer = pretender;
            }
        }

        return answer.intValue() + 1;
    }

    private void check(TreeNode node, int level, BigInteger nodeNum) {

        if (node == null) {
            return;
        }

        if (left[level] == null) {
            left[level] = nodeNum;
        } else {
            if (nodeNum.compareTo(left[level]) < 0) {
                left[level] = nodeNum;
            }
        }

        if (right[level] == null) {
            right[level] = nodeNum;
        } else {
            if (nodeNum.compareTo(right[level]) > 0) {
                right[level] = nodeNum;
            }
        }

        final BigInteger multiply2 = nodeNum.multiply(BigInteger.TWO);
        check(node.left, level + 1, multiply2);
        check(node.right, level + 1, multiply2.add(BigInteger.ONE));
    }

}
