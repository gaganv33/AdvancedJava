package LinkedList;

public class Place {
    private final String name;
    private final double distance;
    public Place(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }
    Place() {
        this.name = "Default";
        this.distance = 500.0;
    }
    public String getName() {
        return this.name;
    }
    public double getDistance() {
        return this.distance;
    }
    @Override
    public String toString() {
        return "Name : " + name + " Distance: " + distance;
    }
}
