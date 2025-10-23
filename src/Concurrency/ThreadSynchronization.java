package Concurrency;

public class ThreadSynchronization {
    private static int counter1 = 0;
    private static int counter2 = 0;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Final thread one: " + counter1);
        System.out.println("Final thread two: " + counter2);
    }

    private static class ThreadOne implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                synchronized (lock1) {
                    counter1++;
                    System.out.println("Thread one: " + counter1);
                }
            }
        }
    }

    private static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 15; i++) {
                synchronized (lock2) {
                    counter2++;
                    System.out.println("Thread two: " + counter2);
                }
            }
        }
    }
}
