package SemaphoreExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    private final String workerName;
    private boolean isAvailable;
    private Runnable task;
    ReentrantLock lock;
    Condition condition;

    public Worker(String workerName) {
        this.workerName = workerName;
        this.isAvailable = true;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void run() {
        System.out.printf("[%s]: Starting worker thread\n", workerName);
        while (true) {
            lock.lock();
            while (task == null) {
                try {
                    System.out.printf("[%s]: Waiting for a task\n", workerName);
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.printf("[%s]: Exception: %s\n", workerName, e.getMessage());
                }
            }
            task.run();
            isAvailable = true;
            task = null;
            lock.unlock();
        }
    }

    public void setTask(Runnable task) {
        lock.lock();
        System.out.printf("[%s]: Setting a task\n", workerName);
        this.task = task;
        isAvailable = false;
        condition.signal();
        lock.unlock();
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
}
