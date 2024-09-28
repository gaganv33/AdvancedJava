package CollectionsRevision;

import java.util.*;

public class TreeSetRevision {
    private static record Student(String name, double marks) {
        private static final List<String> names = new ArrayList<>(List.of("Student 1", "Student 2", "Student 3",
                "Student 4", "Student 5", "Student 6", "Student 7", "Student 8", "Student 9"));
        private static final Random rand = new Random();
        @Override
        public String toString() {
            return "Student: [name: " + this.name + ", marks: " + this.marks + "]";
        }
        public static Student getRandomStudent() {
            return new Student(names.get(rand.nextInt(names.size())), rand.nextDouble(0.0, 100.1));
        }
    }
    public static void start() {
        TreeSet<Student> v = new TreeSet<>(Comparator.comparingDouble(Student::marks));
        ArrayList<Student> list = new ArrayList<>();
        Student student = Student.getRandomStudent();

        // v.add(Object): add the specified element according to the same sorting order.
        for(int i = 0; i < 3; i++) {
            v.add(Student.getRandomStudent());
            list.add(Student.getRandomStudent());
        }
        print(v);

        // v.addAll(Collection): add all elements of the specified collection.
        v.addAll(list);
        print(v);

        // v.ceiling(): returns the least element in this set GREATER THAN OR EQUAL to the given element.
        System.out.println("sample: " + student + "\nceiling(): " + v.ceiling(student));

        // v.floor(): returns the greatest element in this set LESS THAN OR EQUAL to the given element.
        System.out.println("sample: " + student + "\nfloor(): " + v.floor(student));

        // v.comparator(): returns the comparator used to sort elements in the TreeSet.

        // v.contains(Object): returns true if the given element is present in the TreeSet else it will return false.
        System.out.println("sample: " + student + "\ncontains(): " + v.contains(student));

        // v.descendingIterator(): returns a reverse order view of the elements contained in this set.
        Iterator<Student> iterator = v.descendingIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // v.first(): returns the first element in TreeSet
        System.out.println("first(): " + v.first());

        // v.last(): returns the last element in TreeSet
        System.out.println("last(): " + v.last());

        // v.headSet(): returns elements of TreeSet which are LESS THAN the specified element
        print((TreeSet<Student>) v.headSet(student));

        // v.tailSet(): returns the elements of TreeSet which are GREATER THAN OR EQUAL to the specified element
        print((TreeSet<Student>) v.tailSet(student));

        // v.higher(): returns the least element in this set STRICTLY GREATER THAN the given element
        System.out.println("sample: " + student + "\nhigher(): " + v.higher(student));

        // v.lower(): returns the greater element in this set STRICTLY LESS THAN the given element
        System.out.println("sample: " + student + "\nlower(): " + v.lower(student));

        // v.pollFirst(): retrieves and removes the first element
        System.out.println("pollFirst(): " + v.pollFirst());

        // v.pollLast(): retrieves and removes the last element
        System.out.println("pollLast(): " + v.pollLast());

        print(v);

        // v.remove(Object): this method is used to remove a specific element from the set, if the element is removed then it returns True, else False
        System.out.println("remove(): " + v.remove(student));
        print(v);

        // v.subSet(Object fromElement, Object toElement): this method will return elements ranging from fromElement to toElement
        // fromElement inclusive and toElement exclusive
        Student student1 = new Student("Student 1", 50.3);
        Student student2 = new Student("Student 1", 100.1);
        System.out.println("from: " + student1 + " to: " + student2);
        print((TreeSet<Student>) v.subSet(student1, student2));
    }
    public static void print(TreeSet<Student> v) {
        // v.iterator(): returns an iterator for iterating over the elements in the set
        Iterator<Student> iterator = v.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
    }
}
