package ProducerConsumerProblem;

public class Consumer implements Runnable {
    private final SharedResource sharedResource;
    private final int consumerWaitingTime;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.consumerWaitingTime = 4000;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = sharedResource.consumer();
                System.out.printf("[%s]: Consuming data, %d\n", this.getClass().getName(), value);
                Thread.sleep(consumerWaitingTime);
            } catch (InterruptedException e) {
                System.out.printf("[%s]: Exception, %s\n", this.getClass().getName(), e.getMessage());
            }
        }
    }
}
