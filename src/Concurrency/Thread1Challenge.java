package Concurrency;

public class Thread1Challenge {
    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            int i = 0;
            int value = 1;
            while(i <= 5) {
                if(value % 2 == 0) {
                    System.out.println("thread1: " + value);
                    i++;
                }
                try {
                    Thread.sleep(250);
                } catch(InterruptedException e) {
                    System.out.println("thread1 interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
                value++;
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            int i = 0;
            int value = 1;
            while(i <= 5) {
                if(value % 2 == 1) {
                    System.out.println("thread2: " + value);
                    i++;
                }
                try {
                    Thread.sleep(250);
                } catch(InterruptedException e) {
                    System.out.println("thread2 interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
                value++;
            }
        }
    }

    private static class Thread3 implements Runnable {
        private final Thread t1;
        private final Thread t2;
        Thread3(Thread t1, Thread t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void run() {
            long now = System.currentTimeMillis();

            while(t1.isAlive() || t2.isAlive()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if((System.currentTimeMillis() - now) > 3000) {
                    if(t1.isAlive()) {
                        t1.interrupt();
                    }
                    if(t2.isAlive()) {
                        t2.interrupt();
                    }
                }
            }
        }
    }

    public static void start() {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        Thread t3 = new Thread(new Thread3(t1, t2));

        t1.start();
        t2.start();
        t3.start();
    }
}
