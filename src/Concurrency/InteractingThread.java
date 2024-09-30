package Concurrency;

public class InteractingThread {
    public static void start() {
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(". ");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("thread1 was interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            long now = System.currentTimeMillis();
            while(thread1.isAlive()) {
                try {
                    Thread.sleep(1000);
                    if((System.currentTimeMillis() - now) > 2000) {
                        thread1.interrupt();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 3; i++) {
                try {
                    System.out.println("- ");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread1 was interrupted.");
        }

        if(thread1.isInterrupted()) {
            System.out.println("Cannot start execution of thread3 since, thread1 was interrupted.");
        } else {
            System.out.println("thread1 executed.");
            thread3.start();
            try {
                thread3.join();
            } catch (InterruptedException e) {
                System.out.println("thread3 was interrupted.");
            }
        }
    }
}
