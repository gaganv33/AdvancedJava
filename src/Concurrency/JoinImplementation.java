package Concurrency;

public class JoinImplementation {
    private static int counter1 = 0;
    private static int counter2 = 0;
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
           for(int i = 0; i < 10; i++) {
               System.out.println("Thread one: " + counter1);
               counter1++;
           }
        });

        Thread two = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Thread two: " + counter2);
                counter2++;
            }
        });

        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("final Thread one: " + counter1);
        System.out.println("final Thread two: " + counter2);
    }
}
