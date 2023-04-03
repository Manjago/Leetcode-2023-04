public class LeetCode00724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i<nums.length; ++i) {
            rightSum += nums[i];
        }
        System.out.println("leftSum = " + leftSum + ", rightSum = " + rightSum);

        for(int i = 0; i<nums.length; ++i) {
            rightSum -= nums[i];
            System.out.println("i = " + i + ", leftSum = " + leftSum + ", rightSum = " + rightSum) ;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
