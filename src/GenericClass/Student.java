package GenericClass;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final int gpa;
    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public Student() {
        this.name = "Default";
        this.gpa = 8;
    }
    public int getGpa() {
        return this.gpa;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "Student[name: " + this.name + " gpa: " +this.gpa + "]";
    }
    public static void start() {
        final List<Student> v = new ArrayList<>(List.of(
                new Student("a", 6),
                new Student("z", 9),
                new Student("v", 7),
                new Student("q", 8),
                new Student("p", 10)
        ));
        System.out.println("Order by name");
        v.sort(new StudentComparator<Student>("name"));
        for(var s : v) {
            System.out.println(s);
        }
        System.out.println("Order by gpa");
        v.sort(new StudentComparator<Student>("gpa"));
        for(var s : v) {
            System.out.println(s);
        }
        Student.<Student>printList(v);
    }
    public static <T extends Student> void printList(List<T> v) {
        System.out.println("Generic method printing");
        System.out.println("Class: " + v.getClass().getName());
        for(var s : v) {
            System.out.print(s.getGpa() + " " + s.getName() + " ");
            if(s instanceof Family) {
                System.out.println(((Family) s).getFatherName() + " " + ((Family) s).getMotherName());
            }
            System.out.println();
        }
    }
}
