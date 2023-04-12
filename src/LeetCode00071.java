public class LeetCode00071 {
    public String simplifyPath(String path) {

        final SimpleStack stack = new SimpleStack();
        final Tokenizer tokenizer = new Tokenizer(path);
        Item item = tokenizer.nextItem();
        while(item != null) {

            if (stack.empty()) {
                if (item.token != Token.SLASH) {
                    stack.push(item);
                }
            } else {
                switch (item.token) {
                    case SLASH -> {
                        if (stack.peek().token != Token.SLASH) {
                            stack.push(item);
                        }
                    }
                    case CURRENT -> {
                        // do nothing
                    }
                    case UP -> {
                        if (stack.size() != 1) {
                            stack.push(item);
                        }
                    }
                    case WORD -> {
                        stack.push(item);
                    }
                }
            }


            item = tokenizer.nextItem();
        }

        return stack.asString();

    }

    private enum Token {
        SLASH, CURRENT, UP, WORD
    }

    private static class Item {

        private static final Item ISLASH =new Item(Token.SLASH, null);
        private static final Item ICURRENT =new Item(Token.CURRENT, null);
        private static final Item UP =new Item(Token.UP, null);

        private final Token token;
        private final String word;

        private Item(Token token, String word) {
            this.token = token;
            this.word = word;
        }
    }

    private static class Tokenizer {
        private final String data;
        private final int n;
        private int i = 0;
        private StringBuilder sb = null;

        private Tokenizer(String data) {
            this.data = data;
            n = data.length();
        }

        private Item nextItem() {
            if (i >= n) {
                return null;
            }
            final char c = data.charAt(i++);
            switch (c) {
                case '/': {
                    if (sb != null) {
                        --i;
                        final Item result = new Item(Token.WORD, sb.toString());
                        sb = null;
                        return result;
                    }
                    return Item.ISLASH;
                }
                case '.': {

                    if (sb != null) {
                        sb.append(c);
                    }

                    if ((i< n) && data.charAt(i) != '.') {
                        return Item.ICURRENT;
                    } else if (i >= n) {
                        return Item.ICURRENT;
                    } else if (((i + 1)< n) && data.charAt(i + 1) != '.') {
                        return Item.UP;
                    } else if ((i + 1) >= n) {
                        return Item.UP;
                    } else {
                        sb.append(c);
                        sb.append(data.charAt(i++));
                        sb.append(data.charAt(i++));
                    }
                }


            }
            return null;
        }
    }

    private static class SimpleStack {
          private boolean empty() {
              return false;
          }

          private void push(Item item) {

          }

          private Item peek() {
              return null;
          }

          private int size() {
              return 0;
          }

          private String asString() {
              return null;
          }
    }
}
