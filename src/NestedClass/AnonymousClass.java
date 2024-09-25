package NestedClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass {
    public static void start() {
        var comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        List<Integer> v = new ArrayList<>(List.of(5, 8, 9, 59));
        v.sort(comparator);
        System.out.println(v);
    }
}
