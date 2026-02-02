package ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(5);

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
