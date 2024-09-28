package CollectionsRevision;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListRevision {
    private record Name(String firstName, String secondName) {
    }
    public static void start() {
        List<Name> v = new ArrayList<>(List.of(new Name("a", "f"), new Name("r", "z"), new Name("q", "z"), new Name("a", "f")));
        List<Name> w = new ArrayList<>(List.of(new Name("z", "z")));

        // v.add(Object): used to append an element at the end of the list
        v.add(new Name("g", "i"));

        // v.add(index, Object): used to insert an element at a specific position
        v.add(0, new Name("z", "q"));

        // v.addAll(Collection): append all the elements from the given collection to the end of the list
        v.addAll(w);
        print(v);

        // v.addAll(index, Collection): append all the element from the given collection at the specified position
        v.addAll(1, w);
        print(v);

        // v.contains(Object): return true if the element is present in the list, else false
        System.out.println("Contains: " + v.contains(new Name("a", "f")));
        System.out.println("foreach method:");
        v.forEach((element) -> {
            System.out.println(element.firstName + " " + element.secondName);
        });

        // v.indexOf(Object): index of the first occurrence of the specified element is either returned or -1 in case the element is not in the list.
        // v.lastIndexOf(): index of the last occurrence of the specified element is either returned or -1 in case the element is not in the list.
        System.out.println("indexOf: " + v.indexOf(new Name("a", "f")) + " lastIndexOf: " + v.lastIndexOf(new Name("a", "f")));

        // v.remove(Object): removes the first occurrence of the specified element from the list
        v.remove(new Name("a", "f"));
        print(v);

        // v.remove(index): removes the element at the specified position
        v.remove(0);
        print(v);

        // v.removeAll(Collection): Removes from this list all of its elements that are contained in the specified collection.
        v.removeAll(w);
        print(v);

        // v.removeIf(): Removes all of the elements of this collection that satisfy the given predicate.
        v.removeIf((element) -> {
            return element.firstName.equalsIgnoreCase("a");
        });
        print(v);

        // v.retainAll(): Retains only the elements in this list that are contained in the specified collection.
        v.retainAll(List.of(new Name("r", "z"), new Name("q", "z")));
        print(v);

        // v.set(index, Object): Replaces the element at the specified position in this list with the specified element.
        v.set(0, new Name("q", "q"));

        System.out.println("set method and listIterator method");
        ListIterator<Name> iterator = v.listIterator();
        while(iterator.hasNext()) {
            Name name = iterator.next();
            System.out.println("firstName: " + name.firstName + " secondName: " + name.secondName);
        }

        // v.subList(int fromIndex, int toIndex): Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        List<Name> y = v.subList(0, 1);
        y.set(0, new Name("d", "d"));
        print(v);
        print(y);

        List<Name> z = new ArrayList<>(v.subList(0, 1));
        z.set(0, new Name("o", "o"));
        print(v);
        print(z);
    }
    public static void print(List<Name> v) {
        System.out.println(v);
        System.out.println("Size: " + v.size());
        System.out.println("---------------------");
    }
}
