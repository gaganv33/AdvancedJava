package AbstractClass;

public abstract class ListItem {
    protected ListItem leftLink = null;
    protected  ListItem rightLink = null;
    protected Object value;
    ListItem(Object value) {
        this.value = value;
    }
    abstract ListItem next();
    abstract ListItem setNext(ListItem rightLink);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem leftLink);
    abstract  int compareTo(ListItem item);
    public Object getValue() {
        return this.value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
