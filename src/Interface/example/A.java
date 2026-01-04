package Interface.example;

public interface A {
    default void printDefaultMethod() {
        System.out.println("Default method in A");
        printPrivateMethod();
    }

    static void printStaticMethod() {
        System.out.println("Static method in A");
        printPrivateStaticMethod();
    }

    private void printPrivateMethod() {
        System.out.println("Private method in A");
    }

    private static void printPrivateStaticMethod() {
        System.out.println("Private static method in A");
    }
}
