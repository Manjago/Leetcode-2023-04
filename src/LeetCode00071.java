public class LeetCode00071 {

    public static void main(String[] args) {
        final LeetCode00071 s = new LeetCode00071();
        String answer = s.simplifyPath("/../");
        Assert.check(answer.equals("/"), "Bad answer '" + answer + "'");
        answer = s.simplifyPath("/home/");
        Assert.check(answer.equals("/home"), "Bad answer '" + answer + "'");
        answer = s.simplifyPath("/home/");
        Assert.check(answer.equals("/home"), "Bad answer '" + answer + "'");
    }

    public String simplifyPath(String path) {

        final SimpleStack stack = new SimpleStack();
        final String[] items = path.split("/");
        for(String item: items) {
            if (item.isEmpty() || item.equals(".")) {
                continue;
            } else if (item.equals("..")) {
                stack.tryDrop();
            } else {
                stack.push(item);
            }
        }

        return stack.asString();
    }

    private static class SimpleStack {
        private String[] data = new String[3000];
        private int index = 0;

        private void tryDrop() {
           if (index != 0) {
               --index;
           }
        }

        private void push(String s) {
            data[index++] = s;
        }

        private String asString() {

            if (index == 0) {
                return "/";
            }

            final StringBuilder sb = new StringBuilder();

            for(int i = 0; i < index; ++i) {
                sb.append("/");
                sb.append(data[i]);
            }

            return sb.toString();
        }
    }
}
