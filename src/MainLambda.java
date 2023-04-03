import java.util.function.Supplier;

public class MainLambda {
    public static void main(String[] args) {
        testPrint(() -> "Hello, world!");
    }

    public static void testPrint(Supplier<String> s) {
        System.out.println(s.get());
    }
}
