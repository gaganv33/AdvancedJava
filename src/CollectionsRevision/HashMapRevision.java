package CollectionsRevision;

import java.util.*;

public class HashMapRevision {
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
        HashMap<String, StudentData> m = new HashMap<>();
        HashMap<String, StudentData> n = new HashMap<>();

        // m.put():
        for(int i = 0; i < 5; i++) {
            StudentData current = StudentData.getRandomStudentData();
            StudentData prev = m.put("Student" + Integer.toString(i), current);
            System.out.println("Previous data: " + prev + " Current data: " + current);
        }

        // m.putAll(HashMap): Copies all of the mappings from the specified map to this map.
        for(int i = 0; i < 5; i++) {
            n.put("Student" + Integer.toString(i), StudentData.getRandomStudentData());
        }
        System.out.println("New HashMap: ");
        print(n);
        m.putAll(n);
        print(m);

        // m.remove(Object key): Removes the mapping for the specified key from this map if present.
        System.out.println("remove(): " + m.remove("Student1"));
        print(m);

        // m.remove(key, value): Removes the entry for the specified key only if it is currently mapped to the specified value.
        System.out.println("remove(): " + m.remove("Student6", m.get("Student6")));
        print(m);

        // m.size(): Returns the number of key-value mappings in this map.
        System.out.println("size(): " + m.size());

        // m.get(Object key): Returns the value to which the specified key is mapped, or null if this map contains
        // no mapping for the key.
        System.out.println("get(): " + m.get("Student2"));

        // m.getOfrDefault(key, defaultValue): Returns the value to which the specified key is mapped, or defaultValue
        // if this map contains no mapping for the key.
        System.out.println("getOrDefault(): " + m.getOrDefault("Student6", new StudentData(5, 100)));

        // m.keySet(): Returns a Set view of the keys contained in this map.
        Set<String> key = m.keySet();
        System.out.println("keySet(): ");
        key.forEach(System.out::println);

        // m.values(): Returns a Collection view of the values contained in this map.
        Collection<StudentData> value = m.values();
        System.out.println("values(): ");
        value.forEach(System.out::println);

        // m.putIfAbsent(key, newValue): If the specified key is not already associated with a value
        // (or is mapped to null) associates it with the given value and returns null, else returns the current value.
        System.out.println("putIfAbsent(): " + m.putIfAbsent("Student6", new StudentData(5, 100)));
        print(m);

        // m.replace(key, value): Replaces the entry for the specified key only if it is currently mapped to some value.
        // It returns the PREVIOUS VALUE. If there is no such key mapped, then it returns NULL.
        System.out.println("replace(): " + m.replace("Student4", new StudentData(7, 100)));
        print(m);

        // m.replace(key, oldValue, newValue): Replaces the entry for the specified key only if currently mapped to the
        // specified value. This method returns boolean value true if old value was replaced, otherwise false.
        System.out.println("replace(): " + m.replace("Student4", m.get("Student4"), new StudentData(8, 100)));
        print(m);

        // m.replaceAll(BiFunction(key, value): Replaces each entry’s value with the result of invoking the given
        // function on that entry until all entries have been processed or the function throws an exception.
        m.replaceAll((k, v) -> {
            if(v.marks() >= 95) {
                return v;
            }
            return new StudentData(v.grade(), v.marks() + 5);
        });
        print(m);

        // m.compute(key, BiFunction(key, value)): Attempts to compute a mapping for the specified key and its current
        // mapped value (or null if there is no current mapping).
        System.out.println("compute(): ");
        m.compute("Student4", (k, v) -> {
            System.out.println("Data found.");
            return v;
        });

        // m.computeIfAbsent(key, Function(key)): If the specified key is not already associated with a value (or is
        // mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.
        System.out.println("computeIfAbsent(): ");
        m.computeIfAbsent("Student5", (k) -> {
            System.out.println("Data not Found");
            return StudentData.getRandomStudentData();
        });
        print(m);

        // m.computeIfPresent(key, BiFunction(key, value)): If the value for the specified key is present and non-null,
        // attempts to compute a new mapping given the key and its current mapped value.
        System.out.println("computeIfPresent(): ");
        m.computeIfPresent("Student5", (k, v) -> {
            System.out.println("Data found");
            return StudentData.getRandomStudentData();
        });
        print(m);

        // m.containsKey(key): Returns true if this map contains a mapping for the specified key.
        System.out.println("containsKey(): " + m.containsKey("Student4"));

        // m.containsValue(Object): Returns true if this map maps one or more keys to the specified value.
        System.out.println("containsValue(): " + m.containsValue(new StudentData(8, 100.0)));
    }
    public static void print(HashMap<String, StudentData> m) {
        System.out.println("Original HashMap: ");
        m.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
