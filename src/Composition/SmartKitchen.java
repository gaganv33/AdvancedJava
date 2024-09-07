package Composition;

public class SmartKitchen {
    private final CoffeeMaker coffeeMaker;
    private final DishWasher dishWasher;
    private final Refrigerator refrigerator;

    SmartKitchen(CoffeeMaker coffeeMaker, DishWasher dishWasher, Refrigerator refrigerator) {
        this.coffeeMaker = coffeeMaker;
        this.dishWasher = dishWasher;
        this.refrigerator = refrigerator;
    }

    public SmartKitchen() {
        this.coffeeMaker = new CoffeeMaker(false);
        this.dishWasher = new DishWasher(false);
        this.refrigerator = new Refrigerator(false);
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public void addWater() {
        this.coffeeMaker.setHasWorkToDo(true);
    }

    public void pourMilk() {
        this.refrigerator.setHasWorkToDo(true);
    }

    public void loadDishWasher() {
        this.dishWasher.setHasWorkToDo(true);
    }

    public void setKitchenState(boolean cofferMakerHasWorkToDo, boolean dishWasherHasWorkToDo,
                                boolean refrigeratorHasWorkToDo) {
        this.coffeeMaker.setHasWorkToDo(cofferMakerHasWorkToDo);
        this.dishWasher.setHasWorkToDo(dishWasherHasWorkToDo);
        this.refrigerator.setHasWorkToDo(refrigeratorHasWorkToDo);
    }

    public void doKitchenWork() {
        this.coffeeMaker.brewCoffer();
        this.dishWasher.doDishes();
        this.refrigerator.orderFood();
    }
}
