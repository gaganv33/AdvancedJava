package CollectionsRevision;

import java.util.*;

public class HashSetRevision {
    record Name(String firstName, String secondName) {}
    public static void start() {
        Set<Name> s = new HashSet<>();
        List<Name> v = new ArrayList<>(List.of(new Name("a", "v"), new Name("t", "q"), new Name("b", "p"), new Name("a", "v")));
        List<Name> w = new ArrayList<>(List.of(new Name("v", "q"), new Name("r", "u"), new Name("b", "p"), new Name("q", "vz")));

        for(var element: v) {
            boolean res = s.add(element);
            if(res) {
                System.out.println("Element added: " + element);
            } else {
                System.out.println("Element is already present: " + element);
            }
        }
        if(s.contains(new Name("a", "v"))) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element not found");
        }
        s.remove(new Name("a", "v"));
        print(s);
        s.addAll(w);
        print(s);
        System.out.println("containsAll: " + s.containsAll(w));

        System.out.println("forEach method: ");
        s.forEach((element) -> {
            System.out.println(element.firstName + " " + element.secondName);
        });

        s.retainAll(w);
        print(s);
        s.removeIf((element) -> {
            return element.firstName.equalsIgnoreCase("q");
        });
        print(s);
        s.removeAll(w);
        print(s);
    }
    public static void print(Set<Name> s) {
        if(s.isEmpty()) {
            System.out.println("Set is empty.");
            return;
        }
        Iterator<Name> iterator = s.iterator();
        System.out.println("-----------Size: " + s.size() + "------------");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------");
    }
}
