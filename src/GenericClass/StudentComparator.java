package GenericClass;

import java.util.Comparator;

public class StudentComparator <T extends Student> implements Comparator<Student> {
    private final String orderBy;
    StudentComparator(String orderBy) {
        this.orderBy = orderBy;
    }
    StudentComparator() {
        this.orderBy = "gpa";
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(this.orderBy.equalsIgnoreCase("name")) {
            return o1.getName().compareTo(o2.getName());
        }
        else if(this.orderBy.equalsIgnoreCase("gpa")) {
            return o1.getGpa() - o2.getGpa();
        }
        else if(this.orderBy.equalsIgnoreCase("fatherName") && o1 instanceof Family &&
        o2 instanceof Family) {
            return ((Family) o1).getFatherName().compareTo(((Family) o2).getFatherName());
        }
        else if(this.orderBy.equalsIgnoreCase("motherName") && o1 instanceof Family &&
        o2 instanceof Family) {
            return ((Family) o1).getMotherName().compareTo(((Family) o2).getMotherName());
        }
        return 0;
    }
}