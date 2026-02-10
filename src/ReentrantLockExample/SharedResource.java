package ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int counter;
    private final ReentrantLock lock;

    public SharedResource(int counter) {
        this.counter = counter;
        this.lock = new ReentrantLock();
    }

    public void increment() {
        try {
            lock.lock();
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return this.counter;
    }
}
