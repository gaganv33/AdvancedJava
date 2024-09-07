package Composition;

public class Appliance {
    private boolean hasWorkToDo;

    public Appliance(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public Appliance() {
        this.hasWorkToDo = false;
    }

    public boolean getHasWorkToDo() {
        return this.hasWorkToDo;
    }
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}
