package NestedClass;

import java.util.ArrayList;
import java.util.List;

public class LocalClass {
    public static void start() {
        class Employee {
            final private String name;
            final private String id;
            final private int year;
            Employee(String name, String id, int year) {
                this.name = name;
                this.id = id;
                this.year = year;
            }
            Employee() {
                name = "";
                id = "";
                year = 0;
            }
            @Override
            public String toString() {
                return "Employee[name: " + this.name + ", id: " + this.id + ", year: " + this.year + "]";
            }
            public static void printList(List<Employee> v) {
                for (var x : v) {
                    System.out.println(x);
                }
            }
        }
        List<Employee> v = new ArrayList<>(List.of(
                new Employee("a", "g", 2021),
                new Employee("t", "y", 2022),
                new Employee("z", "g", 2023)
        ));
        Employee.printList(v);
    }
}
