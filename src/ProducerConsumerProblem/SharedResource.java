package ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class SharedResource {
    private final int bufferSize;
    private final Deque<Integer> q;

    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        q = new ArrayDeque<>();
    }

    public synchronized void producer(int value) throws InterruptedException {
        while (q.size() == bufferSize) {
            System.out.printf("[%s]: Queue is full. Waiting for data to be consumed.\n", this.getClass().getName());
            wait();
        }
        q.offer(value);
        notifyAll();
    }

    public synchronized int consumer() throws InterruptedException {
        while (q.isEmpty()) {
            System.out.printf("[%s]: Queue is empty. Waiting for data to be produced.\n", this.getClass().getName());
            wait();
        }
        int value = q.poll();
        notifyAll();
        return value;
    }
}
