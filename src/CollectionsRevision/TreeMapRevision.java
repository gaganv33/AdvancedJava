package CollectionsRevision;

import java.util.*;

public class TreeMapRevision {
    private static class StudentData {
        private static final Random rand = new Random();
        private final int grade;
        private double marks;
        StudentData(int grade, double marks) {
            this.grade = grade;
            this.marks = marks;
        }
        public int getGrade() {
            return grade;
        }
        public double getMarks() {
            return marks;
        }
        public void setMarks(double marks) {
            this.marks = marks;
        }
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
            return (this.getGrade() == data.getGrade()) && (this.getMarks() == data.getMarks());
        }
    }
    public static void start() {
        TreeMap<String, StudentData> v = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        TreeMap<String, StudentData> w = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        // v.put(key, value): Associates the specified value with the specified key in this map.
        for(int i = 0; i < 5; i++) {
            StudentData current = StudentData.getRandomStudentData();
            StudentData prev = v.put("Student" + Integer.toString(i), current);
            System.out.println("Previous: " + prev + ", Current: " + current);
            w.put("Student" + Integer.toString(i), StudentData.getRandomStudentData());
        }
        print(v);

        // v.putAll(Collection): Copies all the mappings from the specified map to this map.
        v.putAll(w);
        print(v);

        // v.ceilingKey(key): Returns the least key greater than or equal to the given key, or null if there is no such key.
        System.out.println("ceilingKey(): " + v.ceilingKey("Student3"));

        // v.floorKey(key): Returns the greatest key less than or equal to the given key, or null if there is no such key.
        System.out.println("floorKey(): " + v.floorKey("Student0"));

        // v.ceilingEntry(key): Returns a key-value mapping associated with the least key greater than or equal to
        // the given key, or null if there is no such key.
        Map.Entry<String, StudentData> p = v.ceilingEntry("Student1");
        System.out.println(p.getKey() + " " + p.getValue());

        // v.floorEntry(key): Returns a key-value mapping associated with the greatest key less than or equal to
        // the given key, or null if there is no such key.
        Map.Entry<String, StudentData> p1 = v.floorEntry("Student1");
        System.out.println(p1.getKey() + " " + p1.getValue());

        // v.compute(key, BiFunction): Attempts to compute a mapping for the specified key and its current mapped
        // value (or null if there is no current mapping).
        System.out.println("compute(): ");
        v.compute("Student1", (key, value) -> {
            if(value == null) return StudentData.getRandomStudentData();
            if(value.marks >= 95) return value;
            value.setMarks(value.getMarks() + 5);
            return value;
        });
        print(v);

        // v.computeIfAbsent(key, Function(key, value)): If the specified key is not already associated with a value
        // (or is mapped to null), attempts to compute its value using the given mapping function and enters it into
        // this map unless null.
        System.out.println("computeIfAbsent(): ");
        v.computeIfAbsent("Student5", (key) -> {
            return StudentData.getRandomStudentData();
        });
        print(v);

        // v.computeIfPresent(key, BiFunction(key, value)): If the value for the specified key is present and non-null,
        // attempts to compute a new mapping given the key and its current mapped value.
        System.out.println("computeIfPresent(): ");
        v.computeIfPresent("Student1", (key, value) -> {
            if(value.marks >= 95) return value;
            value.setMarks(value.getMarks() + 5);
            return value;
        });
        print(v);

        // v.containsKey(key): Returns true if this map contains a mapping for the specified key.
        System.out.println("containsKey(): " + v.containsKey("Student6"));

        // v.containsValue(value): Returns true if this map maps one or more keys to the specified value.

        // v.descendingKeySet(): Returns a reverse order NavigableSet view of the keys contained in this map.
        System.out.println("descendingKeySet(): ");
        for(var s : v.descendingKeySet()) {
            System.out.print(s + " ");
        }
        System.out.println();

        // v.descendingMap(): Returns a reverse order view of the mappings contained in this map.
        System.out.println("descendingMap(): ");
        print(v.descendingMap());

        // v.entrySet(): Returns a Set view of the mappings contained in this map.
        System.out.println("entrySet(): ");
        Set<Map.Entry<String, StudentData>> s = v.entrySet();
        for(var element: s) {
            if(element.getValue().getMarks() >= 5) {
                element.setValue(new StudentData(element.getValue().getGrade(), element.getValue().getMarks() + 5));
            }
        }
        print(v);

        // v.firstEntry(): Returns a key-value mapping associated with the least key in this map, or null if the map is empty.
        System.out.println("firstEntry(): " + v.firstEntry());

        // v.lastEntry(): Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
        System.out.println("lastEntry(): " + v.lastEntry());

        // v.firstKey(): Returns the first (lowest) key currently in this map.
        System.out.println("firstKey(): " + v.firstKey());

        // v.lastKey(): Returns the last (highest) key currently in this map.
        System.out.println("lastKey(): " + v.lastKey());

        // v.keySet(): Returns a Set view of the keys contained in this map.
        // v.get(key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        System.out.println("keySet() and get(): ");
        for(var element: v.keySet()) {
            System.out.println(element + " " + v.get(element));
        }

        // v.values(): Returns a Collection view of the values contained in this map.
        System.out.println("values(): ");
        for(var element: v.values()) {
            System.out.println(element);
        }

        // v.headMap(key): Returns a view of the portion of this map whose keys are strictly less than toKey.
        // v.headMap(key, inclusive): Returns a view of the portion of this map whose keys are less than
        // (or equal to, if inclusive is true) toKey.
        System.out.println("headMap(): ");
        Map<String, StudentData> data = v.headMap("Student3");
        data.forEach((k, val) -> {
            System.out.println(k + " " + val);
        });

        // v.tailMap(key): Returns a view of the portion of this map whose keys are greater than or equal to fromKey.
        // v.tailMap(key, inclusive): Returns a view of the portion of this map whose keys are greater than
        // (or equal to, if inclusive is true) fromKey.
        System.out.println("tailMap(): ");
        data = v.tailMap("Student3");
        data.forEach((k, val) -> {
            System.out.println(k + " " + val);
        });

        // v.higherEntry(key): Returns a key-value mapping associated with the least key strictly greater than the
        // given key, or null if there is no such key.
        System.out.println("higherEntry(): " + v.higherEntry("Student3"));

        // v.lowerEntry(key): Returns a key-value mapping associated with the greatest key strictly less than the
        // given key, or null if there is no such key.
        System.out.println("lowerEntry(): " + v.lowerEntry("Student3"));

        // v.higherKey(key): Returns the least key strictly greater than the given key, or null if there is no such key.
        System.out.println("higherKey(): " + v.higherKey("Student3"));

        // v.lowerKey(key): Returns the greatest key strictly less than the given key, or null if there is no such key.
        System.out.println("lowerKey(): " + v.lowerKey("Student3"));

        // v.pollFirstEntry(): Removes and returns a key-value mapping associated with the least key in this map,
        // or null if the map is empty.
        System.out.println("pollFirstEntry(): " + v.pollFirstEntry());

        // v.pollLastEntry(): Removes and returns a key-value mapping associated with the greatest key in this map,
        // or null if the map is empty.
        System.out.println("pollLastEntry(): " + v.pollLastEntry());

        print(v);

        // v.subMap(fromKey, toKey): Returns a view of the portion of this map whose keys range from fromKey,
        // inclusive, to toKey, exclusive.
        // v.subMap(fromKey, fromInclusive, toKey, toInclusive): Returns a view of the portion of this map whose keys
        // range from fromKey to toKey.
        System.out.println("subMap(): ");
        print((NavigableMap<String, StudentData>) v.subMap("Student1", "Student3"));
    }
    public static void print(NavigableMap<String, StudentData> v) {
        System.out.println("TreeMap");
        v.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
