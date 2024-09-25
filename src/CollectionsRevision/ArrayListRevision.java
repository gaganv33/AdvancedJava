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

        v.add(new Name("g", "i"));
        v.add(0, new Name("z", "q"));
        v.addAll(w);
        print(v);
        v.addAll(1, w);
        print(v);

        System.out.println("Contains: " + v.contains(new Name("a", "f")));
        System.out.println("foreach method:");
        v.forEach((element) -> {
            System.out.println(element.firstName + " " + element.secondName);
        });

        System.out.println("indexOf: " + v.indexOf(new Name("a", "f")) + " lastIndexOf: " + v.lastIndexOf(new Name("a", "f")));
        v.remove(new Name("a", "f"));
        print(v);
        v.remove(0);
        print(v);
        v.removeAll(w);
        print(v);
        v.removeIf((element) -> {
            return element.firstName.equalsIgnoreCase("a");
        });
        print(v);
        v.retainAll(List.of(new Name("r", "z"), new Name("q", "z")));
        print(v);
        v.set(0, new Name("q", "q"));

        System.out.println("set method and listIterator method");
        ListIterator<Name> iterator = v.listIterator();
        while(iterator.hasNext()) {
            Name name = iterator.next();
            System.out.println("firstName: " + name.firstName + " secondName: " + name.secondName);
        }

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
