package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlaceVisit {
    public void start() {
        LinkedList<Place> v = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("0 - Add more places\n1 - Quit");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 1) {
                break;
            }
            else {
                System.out.println("Enter the name and distance separated by a ',': ");
                String[] data = sc.nextLine().split(",");
                addPlace(v, new Place(data[0], Double.parseDouble(data[1])));
            }
            printList(v);
        } while(true);

        ListIterator<Place> itr = v.listIterator();
        boolean direction = true;
        do {
            System.out.println("Available actions: \n1. Forward\n2. Backward\n3. List of places\n4. Quit");
            int choice = sc.nextInt();
            if(choice == 1) {
                if(!direction) {
                    direction = true;
                    if(itr.hasNext() && itr.hasPrevious()) {
                        itr.next();
                    }
                }
                if(itr.hasNext()) {
                    System.out.println(itr.next());
                }
                else {
                    System.out.println("Next place is not valid");
                }
            }
            else if(choice == 2) {
                if(direction && itr.hasPrevious()) {
                    direction = false;
                    if(itr.hasPrevious() && itr.hasNext()) {
                        itr.previous();
                    }
                }
                if(itr.hasPrevious()) {
                    System.out.println(itr.previous());
                }
                else {
                    System.out.println("Next place is not valid");
                }
            }
            else if(choice == 3) {
                printList(v);
            }
            else {
                break;
            }
        } while(true);
    }
    public static void addPlace(LinkedList<Place> v, Place p) {
        for(Place P : v) {
            if(P.getName().equalsIgnoreCase(p.getName())) {
                System.out.println("Duplicate");
                return;
            }
        }
        ListIterator<Place> itr = v.listIterator();
        int index = 0;
        boolean found = false;
        while(itr.hasNext()) {
            if (itr.next().getDistance() > p.getDistance()) {
                found = true;
                break;
            }
            index++;
        }
        if(found) {
            v.add(index, p);
        }
        else {
            v.addLast(p);
        }
    }
    public static void printList(LinkedList<Place> v) {
        for(Place p : v) {
            System.out.println(p);
        }
    }
}
