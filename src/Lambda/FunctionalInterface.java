package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FunctionalInterface {
    static class CustomComparator implements Comparator<FunctionalInterface> {

        @Override
        public int compare(FunctionalInterface o1, FunctionalInterface o2) {
            int i = o1.firstName.toLowerCase().compareTo(o2.firstName);
            if(i == 0) {
                return secondLevel(o1, o2);
            }
            return i;
        }
        public int secondLevel(FunctionalInterface o1, FunctionalInterface o2) {
            return o1.lastName.toLowerCase().compareTo(o2.lastName);
        }
    }
    final private String firstName;
    final private String lastName;
    FunctionalInterface(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static void start() {
        List<FunctionalInterface> v = new ArrayList<>(List.of(
                new FunctionalInterface("a", "z"),
                new FunctionalInterface("z", "e"),
                new FunctionalInterface("q", "l"),
                new FunctionalInterface("a", "a"),
                new FunctionalInterface("z", "z")
        ));
        FunctionalInterface.CustomComparator comparator = new FunctionalInterface.CustomComparator();
        v.sort(comparator);
        printList(v);
    }
    public static void printList(List<FunctionalInterface> v) {
        for(var x : v) {
            System.out.println(x);
        }
    }
    @Override
    public String toString() {
        return "FunctionalInterface: [firstName: " + this.firstName + ", lastName: " + this.lastName + "]";
    }
}
