package SemaphoreExample;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class WorkerHandler {
    private final Semaphore lock;
    private final ReentrantLock queueLock;
    private final Queue<Worker> q;

    public WorkerHandler(int size) {
        q = new PriorityQueue<>(size, (a, b) -> Boolean.compare(b.getIsAvailable(), a.getIsAvailable()));
        lock = new Semaphore(size);
        queueLock = new ReentrantLock();
        createWorkerThread(size);
    }

    public void submitTask(Runnable task) {
        try {
            lock.acquire();
            Worker worker;
            queueLock.lock();
            try {
                worker = q.poll();
            } finally {
                queueLock.unlock();
            }
            if (worker == null) {
                System.out.printf("[%s]: WorkerHandler is null\n", getClass().getName());
                return;
            }
            worker.setTask(task);
            queueLock.lock();
            try {
                q.offer(worker);
            } finally {
                queueLock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.printf("[%s]: Exception: %s\n", getClass().getName(), e.getMessage());
        } finally {
            lock.release();
        }
    }

    private void createWorkerThread(int size) {
        for (int i = 1; i <= size; i++) {
            String workerName = "Worker Thread Name - " + i;
            Worker worker = new Worker(workerName);
            Thread workerThread = new Thread(worker);
            workerThread.start();
            q.add(worker);
        }
    }
}
