package ReadWriteLockExample;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        SharedResource sharedResource = new SharedResource();
        Thread writer = getWriterThread("Writer Thread", random, sharedResource);
        Thread reader1 = getReaderThread("Reader Thread - 1", random, sharedResource);
        Thread reader2 = getReaderThread("Reader Thread - 2", random, sharedResource);
        Thread reader3 = getReaderThread("Reader Thread - 3", random, sharedResource);
        Thread reader4 = getReaderThread("Reader Thread - 4", random, sharedResource);
        Thread reader5 = getReaderThread("Reader Thread - 5", random, sharedResource);

        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
    }

    private static Thread getWriterThread(String threadName, Random random, SharedResource sharedResource) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    int key = random.nextInt(1, 10);
                    int value = random.nextInt(1, 10);
                    sharedResource.write(key, value);
                    System.out.printf("[%s]: Written data: key: %s, value: %s\n",
                            Thread.currentThread().getName(), key, value);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.printf("[%s]: Exception: %s\n", Thread.currentThread().getName(), e.getMessage());
                }
            }
        });
        thread.setName(threadName);
        return thread;
    }

    private static Thread getReaderThread(String threadName, Random random, SharedResource sharedResource) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    int key = random.nextInt(1, 10);
                    int value = sharedResource.read(key);
                    System.out.printf("[%s]: Reading data: key: %s, value: %s\n",
                            Thread.currentThread().getName(), key, value);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.printf("[%s]: Exception: %s\n", Thread.currentThread().getName(), e.getMessage());
                }
            }
        });
        thread.setName(threadName);
        return thread;
    }
}
