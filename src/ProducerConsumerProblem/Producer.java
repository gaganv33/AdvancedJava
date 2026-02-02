package ProducerConsumerProblem;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedResource sharedResource;
    private final Random random;
    private final int producerWaitingTime;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.producerWaitingTime = 1000;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = random.nextInt(1, Integer.MAX_VALUE);
                sharedResource.producer(value);
                System.out.printf("[%s]: Inserting data to the queue, %d\n", this.getClass().getName(), value);
                Thread.sleep(producerWaitingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
