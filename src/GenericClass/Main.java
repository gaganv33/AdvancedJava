package GenericClass;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> p = new Pair<>(1, 23);
        System.out.println(p.first() + " " + p.second());
    }
}
