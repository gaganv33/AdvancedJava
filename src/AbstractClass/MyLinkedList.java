package AbstractClass;

import java.util.Scanner;

public class MyLinkedList implements NodeList {
    protected ListItem start;
    protected ListItem end;
    public MyLinkedList(ListItem root) {
        this.start = root;
        this.end = root;
    }
    public static void start() {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList(new Node(""));
        do {
            System.out.println("""
                    0 - Quit
                    1 - Add item
                    2 - Remove Item""");
            int choice = 3;
            try {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
            }

            if(choice == 0) {
                break;
            } else if(choice == 1) {
                String data = sc.nextLine();
                boolean ans = list.addItem(new Node(data));
                System.out.println(ans);
            } else if(choice == 2) {
                String data = sc.nextLine();
                boolean ans = list.removeItem(new Node(data));
                System.out.println(ans);
            }
            list.traverse();
        } while(true);
    }
    @Override
    public ListItem getRoot() {
        return this.start;
    }

    @Override
    public boolean addItem(ListItem root) {
        if(this.start == null) {
            this.start = root;
            this.end = this.start;
            return true;
        }
        if(this.start.compareTo(root) >= 0) {
            root.setNext(this.start);
            this.start = root;
        }
        else if(this.end.compareTo(root) < 0) {
            this.end = this.end.setNext(root);
        }
        else {
            ListItem prev = null;
            ListItem node = this.start;
            while(node != null) {
                if(node.compareTo(root) >= 0) {
                    root.setPrevious(prev);
                    root.setNext(node);
                    node.setPrevious(root);
                    if(prev != null) {
                        prev.setNext(root);
                    }
                    break;
                }
                prev = node;
                node = node.next();
            }
        }
        return true;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(this.start == null) {
            System.out.println("List is empty");
            return false;
        }
        if(((String) this.start.getValue()).compareTo((String) item.getValue()) == 0) {
            this.start = this.start.next();
            return true;
        } else {
            ListItem prev = null;
            ListItem node = this.getRoot();
            while(node != null) {
                if(((String) node.getValue()).compareTo((String) item.getValue()) == 0) {
                    ListItem next = node.next();
                    if(prev != null) {
                        prev.setNext(next);
                    }
                    if(next != null) {
                        next.setPrevious(prev);
                    }
                    return true;
                }
                prev = node;
                node = node.next();
            }
        }
        return false;
    }

    @Override
    public void traverse() {
        if(this.start == null) {
            System.out.println("The list is empty");
        } else {
            ListItem node = this.getRoot();
            while(node != null) {
                System.out.print(node.getValue() + " ");
                node = node.next();
            }
            System.out.println();
        }
    }
}
