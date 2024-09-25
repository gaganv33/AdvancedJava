package NestedClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StaticNestedClass {
    public static class SortComparator<T extends StaticNestedClass> implements Comparator<T> {
        private final String orderBy;
        SortComparator(String orderBy) {
            this.orderBy = orderBy;
        }
        @Override
        public int compare(T o1, T o2) {
            if(this.orderBy.toLowerCase().compareTo("name") == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            else if(this.orderBy.toLowerCase().compareTo("id") == 0) {
                return o1.getId().compareTo(o2.getId());
            }
            else if(this.orderBy.toLowerCase().compareTo("year") == 0) {
                return o1.getYear() - o2.getYear();
            }
            return o1.getName().compareTo(o2.getName());
        }
    }
    final private String name;
    final private String id;
    final private int year;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    StaticNestedClass(String name, String id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }
    public static void start() {
        List<StaticNestedClass> v = new ArrayList<>(List.of(
                new StaticNestedClass("a", "b", 2021),
                new StaticNestedClass("z", "a", 20222),
                new StaticNestedClass("f", "e", 2024)
        ));
        System.out.println("Order by name");
        StaticNestedClass.sortList(v, "name");
        printList(v);
        System.out.println("Order by id");
        StaticNestedClass.sortList(v, "id");
        printList(v);
        System.out.println("Order by year");
        StaticNestedClass.sortList(v, "year");
        printList(v);
    }
    public static void sortList(List<StaticNestedClass> v, String orderBy) {
        v.sort(new StaticNestedClass.SortComparator<StaticNestedClass>(orderBy));
    }
    public static void printList(List<StaticNestedClass> v) {
        for(var s : v) {
            System.out.println(s);
        }
    }
    @Override
    public String toString() {
        return "StaticNestClass: " + this.name + " " + this.id + " " + this.year;
    }
}
