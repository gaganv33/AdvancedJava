package Interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (value) -> {
            if (value % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
        };
        consumer.accept(10);

        Supplier<String> supplier = () -> "Even Number";
        supplier.get();

        Function<Integer, String> function = (value) -> {
            if (value % 2 == 0) return "Even";
            else return "Odd";
        };
        System.out.println(function.apply(11));

        Predicate<Integer> predicate = (value) -> {
            return value % 2 == 0;
        };
        System.out.println(predicate.test(12));
    }
}
