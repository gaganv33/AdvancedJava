package CollectionsRevision;

import java.util.*;

public class LinkedHashSetRevision {
    record Name(String firstName, String secondName) {}
    public static void start() {
        Set<Name> s = new LinkedHashSet<>();
        List<Name> v = new ArrayList<>(List.of(new Name("a", "r"), new Name("r", "qw"), new Name("p", "qw"),
                new Name("a", "r")));
        List<Name> w = new ArrayList<>(List.of(new Name("ad", "r"), new Name("rr", "w"), new Name("y", "qzw"),
                new Name("at", "rq")));
        Name a = new Name("rr", "q");
        Name b = new Name("rr", "w");

        // s.add(Object): Adds the specified element to this set if it is not already present.
        for(var element : v) {
            boolean res = s.add(element);
            if(res) {
                System.out.println("Element added: " + element);
            } else {
                System.out.println("Element already present: " + element);
            }
        }

        // s.addAll(Collection): Adds all of the elements in the specified collection to this collection
        // (optional operation).
        s.addAll(w);
        print(s);

        // s.contains(Object): Returns true if this set contains the specified element.
        System.out.println("contains: " + s.contains(a) + " " + a);
        System.out.println("contains: " + s.contains(b) + " " + b);

        // s.containsAll(Collection): Returns true if this collection contains all the elements in the specified
        // collection.
        System.out.println("containsAll: " + s.containsAll(w));

        // s.remove(Object): Removes the specified element from this set if it is present.
        System.out.println("remove: " + a);
        s.remove(a);
        print(s);

        System.out.println("remove: " + b);
        s.remove(b);
        print(s);

        // s.removeIf(Predicate): Removes all the elements of this collection that satisfy the given predicate.
        s.removeIf((element) -> {
            return element.firstName.toLowerCase().charAt(0) == 'a';
        });
        print(s);

        System.out.println("forEach method:");
        s.forEach((element) -> {
            System.out.println(element.firstName + " " + element.secondName);
        });

        // s.retainAll(Collection): This method is used to retain all the elements from the set which are mentioned
        // in the given collection. This method returns true if this set changed as a result of the call.
        System.out.println("retainAll method:");
        s.retainAll(w);
        print(s);

        // s.removeAll(Collection): This method is used to remove all the elements from the collection which are
        // present in the set. This method returns true if this set changed as a result of the call.
        System.out.println("removeAll method:");
        s.removeAll(w);
        print(s);
    }
    public static void print(Set<Name> s) {
        if(s.isEmpty()) {
            System.out.println("LinkedHashSet is empty.");
            return;
        }
        System.out.println("-----------Size: " + s.size() + "------------");
        Iterator<Name> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");
    }
}
