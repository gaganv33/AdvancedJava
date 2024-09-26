package CollectionsRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListRevision {
    public static void start() {
        LinkedList<Integer> v = new LinkedList<>();
        List<Integer> w = new ArrayList<>(List.of(479, 49874, 498));

        v.add(1);
        v.add(0, 45);
        print(v);

        v.addAll(w);
        print(v);
        v.addAll(1, w);
        print(v);

        v.addFirst(100);
        v.addLast(10);
        print(v);

        System.out.println("contains 1: " + v.contains(1));
        System.out.println("contains 145: " + v.contains(145));

        for(int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();

        System.out.println("getFirst(): " + v.getFirst());
        System.out.println("getLast(): " + v.getLast());

        System.out.println("indexOf(): " + v.indexOf(479));
        System.out.println("LastIndexOf(): " + v.lastIndexOf(479));
        System.out.println("element(): " + v.element());
        print(v);

        System.out.println("offer(): " + v.offer(156));
        System.out.println("offerFirst(): " + v.offerFirst(-1));
        System.out.println("offerLast(): " + v.offerLast(-2));
        print(v);

        System.out.println("peek(): " + v.peek());
        System.out.println("peekFirst(): " + v.peekFirst());
        System.out.println("peekLast(): " + v.peekLast());
        print(v);

        System.out.println("poll(): " + v.poll());
        System.out.println("pollFirst(): " + v.pollFirst());
        System.out.println("pollLast(): " + v.pollLast());
        print(v);

        v.push(8);
        print(v);
        System.out.println("pop(): " + v.pop());
        print(v);

        System.out.println("remove(index): " + v.remove(0));
        print(v);
        System.out.println("remove(object): " + v.remove(Integer.valueOf(479)));
        print(v);

        System.out.println("removeFirst(): " + v.removeFirst());
        print(v);
        System.out.println("removeLast(): " + v.removeLast());
        print(v);

        System.out.println("removeFirstOccurrence(): " + v.removeFirstOccurrence(498));
        print(v);
        System.out.println("removeLastOccurrence(): " + v.removeLastOccurrence(498));
        print(v);

        v.set(0, 189);
        print(v);
    }
    public static void print(List<Integer> v) {
        System.out.println("---------");
        ListIterator<Integer> iterator = v.listIterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        while(iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
        System.out.println("---------");
    }
}
