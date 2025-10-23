package Concurrency;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerImplementation {
    public static void main(String[] args) {
        Worker worker = new Worker(0, 10);

        Thread producer = new Thread(() -> {
            try {
                worker.produce();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                worker.consume();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }
}

class Worker {
    private int counter = 0;
    private final int minimum_element_count;
    private final int maximum_element_count;
    private final List<Integer> container;
    private final Object lock = new Object();

    public Worker(int minimum_element_count, int maximum_element_count) {
        this.minimum_element_count = minimum_element_count;
        this.maximum_element_count = maximum_element_count;
        this.container = new ArrayList<>();
    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if(container.size() == maximum_element_count) {
                    System.out.println("The size of container has reached is maximum limit. Wait for elements to be consumed.");
                    lock.wait();
                } else {
                    System.out.println("Adding element to the container: " + counter);
                    container.add(counter++);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if(container.size() == minimum_element_count) {
                    System.out.println("The container is empty. Waiting for elements to be produced.");
                    lock.wait();
                } else {
                    int val = container.removeFirst();
                    System.out.println("Consuming element from the container: " + val);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}