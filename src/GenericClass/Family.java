package GenericClass;

import java.util.ArrayList;
import java.util.List;

public class Family extends Student {
    private final String fatherName;
    private final String motherName;
    Family(String name, int gpa, String fatherName, String motherName) {
        super(name, gpa);
        this.fatherName = fatherName;
        this.motherName = motherName;
    }
    Family() {
        this.fatherName = "Father";
        this.motherName = "Mother";
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }
    @Override
    public String toString() {
        return "Family[name: " + super.getName() + " gpa: " + super.getGpa() + " fatherName: " +
                this.fatherName + " motherName: " + this.motherName + "]";
    }
    public static void start() {
        final List<Family> v = new ArrayList<>(List.of(
                new Family("a", 6, "d", "e"),
                new Family("z", 9, "o", "q"),
                new Family("v", 7, "w", "f"),
                new Family("q", 8, "t", "b"),
                new Family("p", 10, "z", "b")
        ));
        System.out.println("Order by father name");
        v.sort(new StudentComparator<Family>("fatherName"));
        for(var f : v) {
            System.out.println(f);
        }
        System.out.println("Order by mother name");
        v.sort(new StudentComparator<Family>("motherName"));
        for(var f : v) {
            System.out.println(f);
        }

    }
}
