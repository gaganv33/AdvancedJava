package AbstractClass;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem node);
    boolean removeItem(ListItem node);
    void traverse();
}
