public final class Assert {
    private Assert() {
        // mandatory for utility class
    }
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
