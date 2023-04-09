public class LeetCode00704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            final int index = (left + right) / 2;
            final int value = nums[index];
            if (value < target) {
                left = index + 1;
            } else if (value > target) {
                right = index - 1;
            } else {
                return index;
            }
        }
        return -1;
    }
}
