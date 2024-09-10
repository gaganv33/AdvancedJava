package Interface;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;
    Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }
    public static void start(String name, int hitPoints, int strength) {
        Player p = new Player(name, hitPoints, strength);
        System.out.println(p.getName());
        System.out.println(p.getHitPoints());
        System.out.println(p.getStrength());
        System.out.println(p.getWeapon());
        printList(p.write());
        p.read(new ArrayList<>(List.of("Lewis", 44, 100, "Sword")));
        printList(p.write());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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
        return new ArrayList<>(List.of(this.name, this.hitPoints, this.strength, this.weapon));
    }

    @Override
    public void read(List<Object> v) {
        if(v.size() < 4) {
            return;
        }
        this.name = (String) v.get(0);
        this.hitPoints = (int) v.get(1);
        this.strength = (int) v.get(2);
        this.weapon = (String) v.get(3);
    }
    @Override
    public String toString() {
        return "Player{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength= + "
        + this.strength + ", weapon='" + this.weapon + "'}";
    }
    public static void printList(List<Object> v) {
        for(var obj : v) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
