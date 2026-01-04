package Interface.example;

public interface B extends A {
    @Override
    default void printDefaultMethod() {
        A.super.printDefaultMethod();
        System.out.println("Calling from default method B");
        printPrivateStaticMethod();
    }

    private static void printPrivateStaticMethod() {
        System.out.println("Calling private static method B");
    }
}
