package CollectionsRevision;

import java.util.*;

public class HashSetRevision {
    record Name(String firstName, String secondName) {}
    public static void start() {
        Set<Name> s = new HashSet<>();
        List<Name> v = new ArrayList<>(List.of(new Name("a", "v"), new Name("t", "q"), new Name("b", "p"), new Name("a", "v")));
        List<Name> w = new ArrayList<>(List.of(new Name("v", "q"), new Name("r", "u"), new Name("b", "p"), new Name("q", "vz")));

        // s.add(Object): Used to add the specified element if it is not present, if it is present then return false.
        for(var element: v) {
            boolean res = s.add(element);
            if(res) {
                System.out.println("Element added: " + element);
            } else {
                System.out.println("Element is already present: " + element);
            }
        }

        // s.contains(Object): Used to return true if an element is present in a set.
        if(s.contains(new Name("a", "v"))) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element not found");
        }

        // s.remove(Object): Used to remove the element if it is present in set.
        s.remove(new Name("a", "v"));
        print(s);

        // s.addAll(Collection): This method is used to append all the elements from the mentioned collection to the existing set.
        s.addAll(w);
        print(s);

        // s.containsAll(Collection): This method is used to check whether the set contains all the elements present in the given collection or not.
        System.out.println("containsAll: " + s.containsAll(w));

        System.out.println("forEach method: ");
        s.forEach((element) -> {
            System.out.println(element.firstName + " " + element.secondName);
        });

        // s.retainAll(Collection): This method is used to retain all the elements from the set which are mentioned in the given collection.
        // This method returns true if this set changed as a result of the call.
        s.retainAll(w);
        print(s);

        // s.removeIf(Predicate): Removes all the elements of this collection that satisfy the given predicate.
        s.removeIf((element) -> {
            return element.firstName.equalsIgnoreCase("q");
        });
        print(s);

        // s.removeAll(Collection): Removes from this set all of its elements that are contained in the specified collection (optional operation).
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
