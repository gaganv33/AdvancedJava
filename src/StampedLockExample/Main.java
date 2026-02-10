package StampedLockExample;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        SharedResource sharedResource = new SharedResource();

        Thread writerThread1 = getWriterThread("Writer Thread - 1", random, sharedResource);
        Thread writerThread2 = getWriterThread("Writer Thread - 2", random, sharedResource);

        Thread readerThread1 = getReaderThread("Reader Thread - 1", random, sharedResource);
        Thread readerThread2 = getReaderThread("Reader Thread - 2", random, sharedResource);
        Thread readerThread3 = getReaderThread("Reader Thread - 3", random, sharedResource);
        Thread readerThread4 = getReaderThread("Reader Thread - 4", random, sharedResource);
        Thread readerThread5 = getReaderThread("Reader Thread - 5", random, sharedResource);

        writerThread1.start();
        writerThread2.start();
        readerThread1.start();
        readerThread2.start();
        readerThread3.start();
        readerThread4.start();
        readerThread5.start();
    }

    private static Thread getWriterThread(String threadName, Random random, SharedResource sharedResource) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    int key = random.nextInt(1, 10);
                    int value = random.nextInt(1, 10);
                    sharedResource.write(key, value);
                    Thread.sleep(2000);
                    System.out.printf("[%s]: Write Operation, key: %s, value: %s\n", Thread.currentThread().getName(), key, value);
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
                    Thread.sleep(1000);
                    System.out.printf("[%s]: Read Operation, key: %s, value: %s\n", Thread.currentThread().getName(), key, value);
                } catch (InterruptedException e) {
                    System.out.printf("[%s]: Exception: %s\n", Thread.currentThread().getName(), e.getMessage());
                }
            }
        });
        thread.setName(threadName);
        return thread;
    }
}
