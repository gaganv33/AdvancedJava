package StreamRevision;

import java.util.*;
import java.util.stream.Stream;

public class StreamOptional {
    private static class Student {
        private final String name;
        private final double marks;
        private static final List<String> names = new ArrayList<>(List.of("Student 1", "Student 2", "Student 3", "Student 4",
                "Student 5", "Student 6", "Student 7", "Student 8", "Student 9", "Student 10"));
        private static final Random rand = new Random();
        public Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
        public static Student getRandomStudent() {
            return new Student(names.get(rand.nextInt(names.size())), rand.nextDouble(0.0, 100.1));
        }
        public String getName() {
            return this.name;
        }
        public double getMarks() {
            return this.marks;
        }
        @Override
        public String toString() {
            return "Student[name: " + this.name + ", marks: " + this.marks + "]";
        }
    }
    public static void start() {
        Stream.generate(Student::getRandomStudent)
                .limit(10)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .dropWhile((s) -> s.getMarks() < 50)
                .peek(System.out::println)
                .takeWhile((s) -> s.getMarks() >= 60 && s.getMarks() <= 80)
                .forEach(System.out::println);

        System.out.println();

        Stream.generate(Student::getRandomStudent)
                .limit(30)
                .max(Comparator.comparingDouble(Student::getMarks))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No Student with maximum marks found."));

        System.out.println();

        Stream.generate(Student::getRandomStudent)
                .limit(30)
                .min(Comparator.comparingDouble(Student::getMarks))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No Student with minimum marks found."));

        System.out.println();

        Stream.generate(Student::getRandomStudent)
                .limit(30)
                .filter((s) -> s.getMarks() >= 50)
                .collect(() -> new TreeSet<>(Comparator.comparingDouble(Student::getMarks)),
                        (s, data) -> s.add(data), (s, t) -> s.addAll(t))
                .forEach(System.out::println);

        System.out.println();

        Stream.generate(Student::getRandomStudent)
                .limit(10)
                .filter((s) -> s.getMarks() >= 95)
                .findAny()
                .ifPresentOrElse((s) -> System.out.println("Found: " + s), () -> System.out.println("Data Not Found."));
    }
}
