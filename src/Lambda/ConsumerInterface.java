package Lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void start() {
        Consumer<Integer> functionConsumer = (a) -> {
            System.out.println(a * 10);
        };
        BiConsumer<Integer, Double> functionBiConsumer = (Integer a, Double b) -> {
            double c = Double.valueOf(a) + b;
            System.out.println(c);
        };
        consumer(functionConsumer, 5);
        biconsumer(functionBiConsumer, 5, 10.2);
    }
    private static void consumer(Consumer<Integer> function, int a) {
        function.accept(a);
    }
    private static void biconsumer(BiConsumer<Integer, Double> function, int a, double b) {
        function.accept(a, b);
    }
}
