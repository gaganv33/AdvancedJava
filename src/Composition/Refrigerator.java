package Composition;

public class Refrigerator extends Appliance {
    Refrigerator(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    Refrigerator() {
        super(false);
    }
    public void orderFood() {
        if(super.getHasWorkToDo()) {
            System.out.println("order food method");
            super.setHasWorkToDo(false);
        }
    }
}
