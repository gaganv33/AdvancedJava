package Interface.example;

public class Main {
    public static void main(String[] args) {
        A a = new AImpl();
        B b = new BImpl();

        System.out.println("---");
        a.printDefaultMethod();
        A.printStaticMethod();
        System.out.println("---");
        b.printDefaultMethod();
    }
}
