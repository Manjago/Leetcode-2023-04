import java.util.ArrayList;
import java.util.List;

public class LeetCode00021 {
    public boolean isValid(String s) {

        final int n = s.length();
        final LameStack stack = new LameStack(n);

        for (int i = 0; i < n; ++i) {
            final char c = s.charAt(i);
            switch (c) {
                case '(', '[', '{':
                    stack.push(c);
                    break;
                case ')':
                    if ('(' != stack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if ('[' != stack.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if ('{' != stack.pop()) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected " + c);
            }
        }

        return stack.isEmpty();

    }

    private static class LameStack {

        private final List<Character> data;

        public LameStack(int maxDepth) {
            data = new ArrayList<Character>(maxDepth);
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public void push(char c) {
            data.add(c);
        }

        public char pop() {
            if (isEmpty()) {
                return '0';
            } else {
                final char result = data.get(data.size() - 1);
                data.remove(data.size() - 1);
                return result;
            }
        }

    }
}
