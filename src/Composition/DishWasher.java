package Composition;

public class DishWasher extends Appliance {
    DishWasher(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    DishWasher() {
        super(false);
    }
    public void doDishes() {
        if(super.getHasWorkToDo()) {
            System.out.println("do dishes method");
            super.setHasWorkToDo(false);
        }
    }
}
