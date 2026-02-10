package ReentrantLockExample;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(0);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.increment();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.increment();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sharedResource.getCounter());
    }
}
