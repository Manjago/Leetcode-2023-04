public class LeetCode00258 {
    public int addDigits(int num) {
        int prev = num;
        int current = -1;
        while(true) {
            current = transform(prev);
            if (current == prev) {
                return current;
            }
            prev = current;
        }
    }

    private static int transform(int num) {
        int remain = num;
        int acc = 0;

        while(remain >= 10) {
            int digit = remain % 10;
            remain = remain / 10;
            acc += digit;
        }

        return acc + remain;
    }
}
