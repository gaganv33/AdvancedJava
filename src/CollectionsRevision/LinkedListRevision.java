package CollectionsRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListRevision {
    public static void start() {
        LinkedList<Integer> v = new LinkedList<>();
        List<Integer> w = new ArrayList<>(List.of(479, 49874, 498));

        // v.add(Object): This method Appends the specified element to the end of this list.
        v.add(1);

        // v.add(index, Object): This method Inserts the specified element at the specified position in this list.
        v.add(0, 45);
        print(v);

        // v.addAll(Collection): This method Appends all the elements in the specified collection to the end of
        // this list, in the order that they are returned by the specified collection’s iterator.
        v.addAll(w);
        print(v);

        // v.addAll(index, Collection): This method Inserts all the elements in the specified collection into this
        // list, starting at the specified position.
        v.addAll(1, w);
        print(v);

        // v.addFirst(Object): This method Inserts the specified element at the beginning of this list.
        v.addFirst(100);

        // v.addLast(Object): This method Appends the specified element to the end of this list.
        v.addLast(10);
        print(v);

        // v.contains(Object): This method returns true if this list contains the specified element.
        System.out.println("contains 1: " + v.contains(1));
        System.out.println("contains 145: " + v.contains(145));

        // v.get(index): This method returns the element at the specified position in this list.
        for(int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();

        // v.getFirst(): This method returns the first element in this list.
        System.out.println("getFirst(): " + v.getFirst());

        // v.getLast(): This method returns the last element in this list.
        System.out.println("getLast(): " + v.getLast());

        // v.indexOf(Object): This method returns the index of the first occurrence of the specified element in this
        // list, or -1 if this list does not contain the element.
        System.out.println("indexOf(): " + v.indexOf(479));

        // v.lastIndexOf(Object): This method returns the index of the last occurrence of the specified element in
        // this list, or -1 if this list does not contain the element.
        System.out.println("LastIndexOf(): " + v.lastIndexOf(479));

        // v.element(): This method retrieves but does not remove, the head (first element) of this list.
        System.out.println("element(): " + v.element());
        print(v);

        // v.offer(Object): This method Adds the specified element as the tail (last element) of this list.
        System.out.println("offer(): " + v.offer(156));

        // v.offerFirst(Object): This method Inserts the specified element at the front of this list.
        System.out.println("offerFirst(): " + v.offerFirst(-1));

        // v.offerLast(Object): This method Inserts the specified element at the end of this list.
        System.out.println("offerLast(): " + v.offerLast(-2));
        print(v);

        // v.peek(): This method retrieves but does not remove, the head (first element) of this list.
        System.out.println("peek(): " + v.peek());

        // v.peekFirst(): This method retrieves, but does not remove, the first element of this list, or returns
        // null if this list is empty.
        System.out.println("peekFirst(): " + v.peekFirst());

        // v.peekLast(): This method retrieves, but does not remove, the last element of this list,
        // or returns null if this list is empty.
        System.out.println("peekLast(): " + v.peekLast());
        print(v);

        // v.poll(): This method retrieves and removes the head (first element) of this list.
        System.out.println("poll(): " + v.poll());

        // v.pollFirst(): This method retrieves and removes the first element of this list, or returns
        // null if this list is empty.
        System.out.println("pollFirst(): " + v.pollFirst());

        // v.pollLast(): This method retrieves and removes the last element of this list, or returns null if
        // this list is empty.
        System.out.println("pollLast(): " + v.pollLast());
        print(v);

        // v.push(Object): 	This method pushes an element onto the stack represented by this list.
        v.push(8);
        print(v);

        // v.pop(): This method Pops an element from the stack represented by this list.
        System.out.println("pop(): " + v.pop());
        print(v);

        // v.remove(index): This method removes the element at the specified position in this list.
        System.out.println("remove(index): " + v.remove(0));
        print(v);

        // v.remove(Object): This method removes the first occurrence of the specified element from this list
        // if it is present.
        System.out.println("remove(object): " + v.remove(Integer.valueOf(479)));
        print(v);

        // v.removeFirst(): This method removes and returns the first element from this list.
        System.out.println("removeFirst(): " + v.removeFirst());
        print(v);

        // v.removeLast(): This method removes and returns the last element from this list.
        System.out.println("removeLast(): " + v.removeLast());
        print(v);

        // v.removeFirstOccurrence(Object): This method removes the first occurrence of the specified element in this
        // list (when traversing the list from head to tail).
        System.out.println("removeFirstOccurrence(): " + v.removeFirstOccurrence(498));
        print(v);

        // v.removeLastOccurrence(Object): This method removes the last occurrence of the specified element in this
        // list (when traversing the list from head to tail).
        System.out.println("removeLastOccurrence(): " + v.removeLastOccurrence(498));
        print(v);

        // v.set(index, Object): This method replaces the element at the specified position in this list with the
        // specified element.
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
