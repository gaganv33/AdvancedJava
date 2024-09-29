package CollectionsRevision;

import java.util.*;

public class LinkedHashMapRevision {
    private record StudentData(int grade, double marks) {
        private static final Random rand = new Random();

        @Override
        public String toString() {
            return "StudentData [grade: " + this.grade + ", marks: " + this.marks + "]";
        }

        public static StudentData getRandomStudentData() {
            return new StudentData(rand.nextInt(1, 11), rand.nextDouble(0.0, 100.1));
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            StudentData data = (StudentData) obj;
            return (this.grade() == data.grade()) && (this.marks() == ((StudentData) obj).marks());
        }
    }

    public static void start() {
        LinkedHashMap<String, StudentData> v = new LinkedHashMap<>();

        for(int i = 0; i < 5; i++) {
            v.put("Student" + Integer.toString(i), StudentData.getRandomStudentData());
        }
        print(v);

        // v.putFirst(key, value): Inserts the given mapping into the map if it is not already present,
        // or replaces the value of a mapping if it is already present (optional operation).
        v.putFirst("Student3", StudentData.getRandomStudentData());
        print(v);

        // v.putLast(key, value): Inserts the given mapping into the map if it is not already present,
        // or replaces the value of a mapping if it is already present (optional operation).
        v.putFirst("Student10", StudentData.getRandomStudentData());
        print(v);

        // v.sequencedValues(): Returns a SequencedCollection view of this map's values collection.
        System.out.println("sequencedValues(): ");
        SequencedCollection<StudentData> values = v.sequencedValues();
        Iterator<StudentData> iterator = values.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // v.sequencedKeySet(): Returns a SequencedSet view of this map's keySet.
        System.out.println("sequencedKeySet(): ");
        SequencedSet<String> key = v.sequencedKeySet();
        Iterator<String> iterator1 = key.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
    public static void print(LinkedHashMap<String, StudentData> v) {
        System.out.println("LinkedHashMap");
        v.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
