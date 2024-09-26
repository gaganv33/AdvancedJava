package StreamRevision;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractise {
    public static void start() {
        List<String> v = new ArrayList<>(List.of("fiefibfe", "abiw", "abifihw", "jwojo", "qugduwgd"));
        v.stream()
                .filter(s -> s.toLowerCase().charAt(0) == 'a')
                .map(s -> {
                    return s.charAt(0) + "-" + s.substring(1);
                })
                .forEach(s -> System.out.println(s));

        System.out.println("--------------");

        var firstStream = v.stream()
                .filter(s -> s.toLowerCase().charAt(0) == 'a')
                .map(s -> s.charAt(0) + "--" + s.substring(1));
        var secondStream = v.stream()
                .filter(s -> s.toLowerCase().charAt(0) == 'q')
                .map(s -> s.charAt(0) + "-" + s.substring(1));
        Stream.concat(firstStream, secondStream).forEach(s -> System.out.println(s));

        System.out.println("--------------");

        Random rand = new Random();
        Stream.generate(() -> rand.nextInt(1000))
                .limit(15)
                .filter(element -> (element % 2 == 0))
                .forEach(element -> System.out.print(element + " "));

        System.out.println("\n--------------");

        Stream.generate(() -> rand.nextInt(1000))
                .limit(20)
                .filter(element -> (element % 2 == 1))
                .forEach(element -> System.out.print(element + " "));

        System.out.println("\n--------------");

        Stream.iterate(1, s -> s + 5)
                .limit(1000)
                .filter(s -> s % 2 == 0)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n--------------");

        Stream.iterate(1, s -> s <= 1500, s -> s + 3)
                .filter(s -> (s % 2 == 1))
                .limit(20)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n--------------");

        IntStream.range(1, 100)
                .filter(s -> s % 2 == 0)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n--------------");

        IntStream.rangeClosed(1, 101)
                .filter(s -> s % 2 == 1)
                .forEach(s -> System.out.print(s + " "));
    }
}
