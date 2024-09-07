package Composition;

public class CoffeeMaker extends Appliance {
    CoffeeMaker(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    CoffeeMaker() {
        super(false);
    }
    public void brewCoffer() {
        if(this.getHasWorkToDo()) {
            System.out.println("Brew Coffee method.");
            super.setHasWorkToDo(false);
        }
    }
}
