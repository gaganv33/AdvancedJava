package Interface;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<Object> write() {
        return new ArrayList<>(List.of(this.name, this.hitPoints, this.strength));
    }

    @Override
    public void read(List<Object> v) {
        if(v.size() < 4) {
            return;
        }
        this.name = (String) v.get(0);
        this.hitPoints = (int) v.get(1);
        this.strength = (int) v.get(2);
    }
    @Override
    public String toString() {
        return "Player{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength= + "
        + this.strength + "}";
    }
}
