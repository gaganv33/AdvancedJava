package NestedClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InnerClass {
    public class InnerClassComparator <T extends InnerClass> implements Comparator<T> {
        final private String orderBy;
        InnerClassComparator(String orderBy) {
            this.orderBy = orderBy;
        }
        @Override
        public int compare(T o1, T o2) {
            if(this.orderBy.toLowerCase().compareTo("name") == 0) {
                return o1.getName().compareTo(o2.getName());
            } else if(this.orderBy.toLowerCase().compareTo("id") == 0) {
                return o1.getId().compareTo(o2.getId());
            } else if(this.orderBy.toLowerCase().compareTo("year") == 0) {
                return o1.getYear() - o2.getYear();
            }
            return o1.getName().compareTo(o2.getName());
        }
    }
    final private String name;
    final private String id;
    final private int year;
    InnerClass(String name, String id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }
    InnerClass() {
        this.name = "Default";
        this.id = "1";
        this.year = 2020;
    }
    public String getId() {
        return id;
    }
    public int getYear() {
        return year;
    }
    public String getName() {
        return name;
    }
    public static void start() {
        List<InnerClass> v = new ArrayList<>(List.of(
                new InnerClass("a", "z", 2024),
                new InnerClass("g", "a", 2022),
                new InnerClass("y", "a", 2021)
        ));
        InnerClass.InnerClassComparator<InnerClass> comparatorName =
                new InnerClass().new InnerClassComparator<InnerClass>("name");
        v.sort(comparatorName);
        System.out.println("Ordered by name");
        printList(v);

        InnerClass.InnerClassComparator<InnerClass> comparatorId =
                new InnerClass().new InnerClassComparator<InnerClass>("id");
        v.sort(comparatorId);
        System.out.println("Ordered by id");
        printList(v);

        InnerClass.InnerClassComparator<InnerClass> comparatorYear =
                new InnerClass().new InnerClassComparator<InnerClass>("year");
        v.sort(comparatorYear);
        System.out.println("Ordered by year");
        printList(v);
    }
    public static void printList(List<InnerClass> v) {
        for(var s : v) {
            System.out.println(s);
        }
    }
    @Override
    public String toString() {
        return "InnerClass: [" + this.name + ", " + this.id + ", " + this.year + "]";
    }
}
