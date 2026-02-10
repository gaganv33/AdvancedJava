package StampedLockExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    private final Map<Integer, Integer> mp;
    private final StampedLock lock;

    public SharedResource() {
        mp = new HashMap<>();
        lock = new StampedLock();
    }

    public void write(int key, int value) {
        long stamp = lock.writeLock();
        try {
            mp.put(key, value);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("[%s.write]: Exception: %s\n", this.getClass().getName(), e.getMessage());
        } finally {
            lock.unlock(stamp);
        }
    }

    public int read(int key) {
        long stamp = lock.tryOptimisticRead();
        // Reading data without a lock
        int value = mp.getOrDefault(key, -1);
        // Before returning, the value, we validate if any change to the shared resource was done, if it was done,
        // then we acquire a read lock and then read the data again.
        if (!lock.validate(stamp)) {
            System.out.println("--- Acquiring a read lock ---");
            stamp = lock.readLock();
            try {
                value = mp.getOrDefault(key, -1);
            } finally {
                lock.unlock(stamp);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.printf("[%s.read]: Exception: %s\n", this.getClass().getName(), e.getMessage());
        }
        return value;
    }
}
