package ReadWriteLockExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private final Map<Integer, Integer> mp;
    private final ReadWriteLock lock;

    public SharedResource() {
        this.mp = new HashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    public void write(int key, int value) {
        try {
            lock.writeLock().lock();
            mp.put(key, value);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.printf("[%s.write]: Exception: %s\n", this.getClass().getName(), e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int read(int key) {
        int res = -1;
        try {
            lock.readLock().lock();
            res = mp.getOrDefault(key, -1);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.printf("[%s.read]: Exception: %s\n", this.getClass().getName(), e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
        return res;
    }
}
