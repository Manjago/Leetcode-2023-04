/*
Intuition

It seemed to me that the stack is suitable for this task - this task is something similar to the task with bracket validation.

We put the star at the top of the stack and at that moment we "annihilate" the char. With this approach, there will be no stars at all on the stack.
And at the end it will be necessary to return the inverted string based on the stack.
Approach

I did not use the library implementation of the stack, but instead used my class using an array - this is faster (we know the limits on the length of the string) and it will be faster to reverse the string at the last stage.
Complexity

    Time complexity: O(n)

Two passes, each O(n)
The first O(n) pass - iterate over the entire line and put the data on the stack.
The second O(n) pass - collect data from the stack.

    Space complexity: O(n)

We use a stack with a max size of nnn ints and use a string of size nnn for the answer
 */
public class LeetCode02390 {
    public String removeStars(String s) {
        final LameStack stack = new LameStack();
        for(int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.toReverseString();
    }

    private static class LameStack {
        private char[] data = new char[100000];
        private int current = 0;
        private boolean empty() {
            return current == 0;
        }
        private void push(char c) {
            data[current++] = c;
        }
        private char pop() {
            return data[--current];
        }
        private String toReverseString() {
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < current; ++i) {
                sb.append(data[i]);
            }
            return sb.toString();
        }
    }
}
