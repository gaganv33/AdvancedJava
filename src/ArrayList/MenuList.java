package ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuList {
    private final ArrayList<String> v;
    public MenuList() {
        v = new ArrayList<String>();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any items (comma delimited list)
                    Enter a number for which action you want to do""");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 0) {
                return;
            } else if (choice == 1) {
                String[] nameList = sc.nextLine().split(",");
                addItemToList(v, nameList);
            } else if (choice == 2) {
                String[] nameList = sc.nextLine().split(",");
                removeItemToList(v, nameList);
            }
        } while(true);
    }
    private void addItemToList(ArrayList<String> v, String[] nameList) {
        for(String name : nameList) {
            if(v.contains(name)) {
                System.out.println(name + " exists in the list");
            }
            else {
                v.add(name);
            }
        }
        v.sort(Comparator.naturalOrder());
        printList(v);
    }
    private void removeItemToList(ArrayList<String> v, String[] nameList) {
        v.removeAll(List.of(nameList));
        printList(v);
    }
    private static void printList(ArrayList<String> v) {
        System.out.println(v);
    }
}
